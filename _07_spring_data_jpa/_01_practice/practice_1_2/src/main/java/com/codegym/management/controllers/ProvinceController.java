package com.codegym.management.controllers;

import com.codegym.management.models.Customer;
import com.codegym.management.models.Province;
import com.codegym.management.services.customer.ICustomerService;
import com.codegym.management.services.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/provinces")
    public ModelAndView showProvinceList() {
        ModelAndView modelAndView = new ModelAndView("/province/provinceList");
        List<Province> provinceList = provinceService.findAll();
        modelAndView.addObject("provinces", provinceList);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/createProvince");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView createProvince(@ModelAttribute Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/createProvince");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "Add province successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @PostMapping("/edit-province")
    public ModelAndView editProvince(@ModelAttribute Province province, @RequestParam String confirmEdit)
    {
        if (confirmEdit.equals("accept")) {
            provinceService.save(province);
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            modelAndView.addObject("message", "Edit province successfully!");
            return modelAndView;
        }
        return showProvinceList();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView confirmDelete(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/province/delete");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteProvice(@ModelAttribute Province province,
                                      @RequestParam(name = "confirmDelete") String confirm)
    {
        ModelAndView modelAndView = new ModelAndView("/province/provinceList");
        if (confirm.equals("yes")) {
            provinceService.delete(province);
            modelAndView.addObject("message", "Delete province successfully!");
        }
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showCustomersInProvince(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        List<Customer> customerList = customerService.findAllByProvince(province);
        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }
}
