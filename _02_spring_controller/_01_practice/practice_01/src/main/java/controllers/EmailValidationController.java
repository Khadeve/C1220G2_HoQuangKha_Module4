package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailValidationController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    private static boolean validateData(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @GetMapping
    public String getHomePage() {
        return "home";
    }

    @PostMapping("/validate")
    public ModelAndView user(@RequestParam String email) {
        boolean isValidEmail = validateData(email);
        if (isValidEmail) {
            return new ModelAndView("success", "email", email);
        }
        return new ModelAndView("home", "message", "Invalid email!");
    }
}
