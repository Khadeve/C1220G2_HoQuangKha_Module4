package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/calculate")
    public ModelAndView calculateResult(@RequestParam double firstOperand, @RequestParam double secondOperand,
                                        @RequestParam String operator) {
        ModelAndView modelAndView = new ModelAndView("result");
        double result = 0;
        switch (operator) {
            case "Addition":
                result = firstOperand + secondOperand;
                break;
            case "Subtraction":
                result = firstOperand - secondOperand;
                break;
            case "Multiplication":
                result = firstOperand * secondOperand;
                break;
            default:
                result = firstOperand / secondOperand;
        }
        modelAndView.addObject("firstOperand", firstOperand);
        modelAndView.addObject("secondOperand", secondOperand);
        modelAndView.addObject("operator", operator);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
