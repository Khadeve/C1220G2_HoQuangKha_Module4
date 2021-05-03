package com.codegym.controllers;

import com.codegym.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/showForm")
    public ModelAndView showForm() {
        return new ModelAndView("create", "employee", new Employee());
    }

    @PostMapping("/addEmployee")
    public ModelAndView submit(@ModelAttribute Employee employee) {
//        ModelAndView modelAndView = new ModelAndView("info");
        return new ModelAndView("info", "employee", employee);
    }
}
