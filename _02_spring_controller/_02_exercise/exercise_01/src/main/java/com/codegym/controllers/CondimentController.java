package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentController {

    @GetMapping("/")
    public String display() {
        return "index";
    }

    @GetMapping("/condiment")
    public ModelAndView getSandwichCondiments(@RequestParam(name = "condiments", defaultValue = "") String[] condimentList) {
        ModelAndView modelAndView = new ModelAndView("condiments");
        modelAndView.addObject("condiments", condimentList);
        return modelAndView;
    }
}
