package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.CustomerService;
import com.codegym.services.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private ICustomerService customerService = new CustomerService();

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "customerList", customerService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int)(Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success",
                "add new customer successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
