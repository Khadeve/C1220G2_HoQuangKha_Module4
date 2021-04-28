package controllers;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customerList")
    public String showCustomerList(Model model) {
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "customer-list";
    }

    @GetMapping
    public String updateCustomer(@RequestParam String idStr, Model model) {
        Customer updatedCustomer = customerService.getCustomerById(Integer.parseInt(idStr));
        model.addAttribute("updatedCustomer", updatedCustomer);
        return "info";
    }
}
