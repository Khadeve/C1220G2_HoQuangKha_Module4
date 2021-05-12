package com.codegym.management.controllers;

import com.codegym.management.models.Customer;
import com.codegym.management.models.Province;
import com.codegym.management.services.customer.ICustomerService;
import com.codegym.management.services.province.IProvinceService;
import com.codegym.management.services.util.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/createBootstrap");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) throws DuplicateEmailException {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/createBootstrap");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(@PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        try {
            Customer customer = customerService.findById(id);
            return new ModelAndView("/customer/edit", "customer", customer);
        } catch (Exception e) {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer,
                                       @RequestParam String confirmEdit,
                                       @PageableDefault(value = 3) Pageable pageable) throws DuplicateEmailException {
        if (confirmEdit.equals("accept")) {
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer", customer);
            customerService.save(customer);
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;

        }
        return new ModelAndView("customer/list", "customers", customerService.findAll(pageable));
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        try {
            Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } catch (Exception exception) {
            return new ModelAndView("/error.404");
        }

//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("/customer/delete");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        } else {
//
//        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer);
        return "redirect:/customers";
    }

    @GetMapping("/search-customer")
    public ModelAndView modelAndView(@RequestParam(name = "searchByFirstName") String firstName,
                                     @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customerList = customerService.findAllByFirstNameContaining(firstName, pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customerList);
        modelAndView.addObject("search", firstName);
        return modelAndView;
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public String showInputNotAcceptable() {
        return "/customer/input-not-acceptable";
    }
}
