package com.example.demo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping(value = {"/", "/home"})
    public String getHomePage() {
        return "/welcome";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "/admin";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage() {
        return "/access-denied";
    }

    @GetMapping("/dba")
    public String getDbaPage() {
        return "/dba";
    }
}
