package com.codegym.controllers;

import com.codegym.models.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailBoxController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/setting")
    public ModelAndView setMailBox() {
        return new ModelAndView("setting", "mailBox", new MailBox());
    }

    @PostMapping("/submitSetting")
    public ModelAndView submitSettings(@ModelAttribute MailBox mailBox,
                                       @RequestParam(name = "cancel") String cancel) {
        if (cancel.equals("cancel")) {
            return new ModelAndView("setting", "mailBox", new MailBox());
        }
        return new ModelAndView("settingInfo", "mailBox", mailBox);

    }
}
