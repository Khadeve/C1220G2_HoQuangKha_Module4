package com.codegym.login.controllers;

import com.codegym.login.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {
    @ModelAttribute("user")
    public User setUpUser() {
        return new User();
    }

    @GetMapping("/")
    public ModelAndView showLoginForm(@CookieValue(name = "setUser", defaultValue = "")String setUser) {
        Cookie cookie = new Cookie("setUser", setUser);
        ModelAndView modelAndView = new ModelAndView("/user/login");
        modelAndView.addObject("cookieValue", cookie);
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute(name = "user")User user,
                              @CookieValue(name = "setUser", defaultValue = "")String setUser,
                              HttpServletResponse response)
    {
        if ("admin@gmail.com".equals(user.getUsername()) && "12345".equals(user.getPassword())) {
            setUser = user.getUsername();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);

            ModelAndView modelAndView = new ModelAndView("/user/login");
            modelAndView.addObject("cookieValue", cookie);
            modelAndView.addObject("message", "Login Successfully!");
            return modelAndView;
        } else {
            setUser = "";
            Cookie cookie = new Cookie("setUser", setUser);
            ModelAndView modelAndView = new ModelAndView("/user/login");
            modelAndView.addObject("cookieValue", cookie);
            modelAndView.addObject("message", "Login fail!");
            user.setUsername("");
            return modelAndView;
        }
    }
}
