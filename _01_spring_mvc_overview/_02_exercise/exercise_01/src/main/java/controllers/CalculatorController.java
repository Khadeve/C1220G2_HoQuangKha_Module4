package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculate")
    public String calculateResult(@RequestParam String firstOperand, @RequestParam String secondOperand,
                                  @RequestParam String operator, Model model) {
        int a = Integer.parseInt(firstOperand);
        int b = Integer.parseInt(secondOperand);
        double result;

        switch(operator) {
            case "add":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "multiply":
                result = a * b;
                break;
            default:
                result = (double)a / b;
        }
        model.addAttribute("result", result);
        return "calculate";
    }
}
