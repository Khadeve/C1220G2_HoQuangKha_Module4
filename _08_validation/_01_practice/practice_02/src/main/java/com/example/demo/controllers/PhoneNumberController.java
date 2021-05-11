package com.example.demo.controllers;

import com.example.demo.models.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("index", "phoneNumber", new PhoneNumber());
    }

    @PostMapping("/")
    public ModelAndView validatePhoneNumber(@Valid @ModelAttribute PhoneNumber phoneNumber,
                                            BindingResult bindingResult)
    {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("index");
        }
        return new ModelAndView("result");
    }
}
