package com.codegym.validation.controllers;

import com.codegym.validation.models.User;
import com.codegym.validation.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/user/create", "user", new User());
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/user/create");
        }
        userService.save(user);
        return new ModelAndView("/user/result", "user", user);
    }
}
