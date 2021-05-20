package com.codegym.demo.controllers;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Role;
import com.codegym.demo.models.User;
import com.codegym.demo.services.IBlogService;
import com.codegym.demo.services.IRoleService;
import com.codegym.demo.services.IUserService;
import com.codegym.demo.utils.EncryptPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "/authentication/login";
    }

    @GetMapping("/")
    public ModelAndView showNonMemberListBlog(@PageableDefault(value = 3) @SortDefault(sort = "madeTime", direction = Sort.Direction.DESC) Pageable pageable,
                                     @RequestParam(name = "byName", required = false)String searchByName) {
//        ModelAndView modelAndView = new ModelAndView("/non-member/list");
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        Page<Blog> blogList = null;
        if (searchByName == null || searchByName.isEmpty()) {
            blogList = blogService.findAll(pageable);
        } else {
            blogList = blogService.findAllByNameContaining(searchByName, pageable);
        }
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("search", searchByName);
        return modelAndView;
    }

    @GetMapping("/member")
    public ModelAndView showMemberListBlog(@PageableDefault(value = 3) @SortDefault(sort = "madeTime", direction = Sort.Direction.DESC) Pageable pageable,
                                     @RequestParam(name = "byName", required = false)String searchByName) {
        ModelAndView modelAndView = new ModelAndView("/member/list");
        Page<Blog> blogList = null;
        if (searchByName == null || searchByName.isEmpty()) {
            blogList = blogService.findAll(pageable);
        } else {
            blogList = blogService.findAllByNameContaining(searchByName, pageable);
        }
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("search", searchByName);
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("/authentication/register", "user", new User());
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "user")User user) {
        // Encrypt the password before save to database
        user.setPassword(EncryptPasswordUtil.encryptPassword(user.getPassword()));

        // Set role for new user
        Role roleEntity = roleService.findByName("ROLE_MEMBER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleEntity);
        user.setRoles(roleSet);
        userService.save(user);
        return "redirect:/login";
    }
}
