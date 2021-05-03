package com.codegym.controllers;

import com.codegym.models.Login;
import com.codegym.models.User;
import com.codegym.repositories.UserRepo;
import com.codegym.services.UserService;
import com.codegym.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String goHome() {
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "loginInf", new Login());
    }

    @PostMapping("/checkLogin")
    public ModelAndView checkLogin(@ModelAttribute(value = "loginInf") Login loginInfo) {
        User user = userService.getUser(loginInfo);
        if (user != null) {
            return new ModelAndView("user", "anUser", user);
        } else {
            return new ModelAndView("error");
        }
    }
}
