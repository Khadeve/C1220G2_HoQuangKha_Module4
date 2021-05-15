package com.codegym.product_management.controllers;

import com.codegym.product_management.models.Order;
import com.codegym.product_management.models.Product;
import com.codegym.product_management.services.order.IOrderService;
import com.codegym.product_management.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductService productService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/order/create");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("order") Order order) {
        orderService.save(order);
        ModelAndView modelAndView = new ModelAndView("/order/create");
        modelAndView.addObject("order", new Order());
        modelAndView.addObject("message", "yes");
        return modelAndView;
    }

    @ModelAttribute("products")
    public List<Product> products() {
        return productService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView list() {
        List<Order> orderList = orderService.findAll();
        ModelAndView modelAndView = new ModelAndView("/order/list");
        modelAndView.addObject("orders", orderList);
        return modelAndView;
    }


//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam(name = "searchByName", required = false) String productName,
//                             @RequestParam(name = "searchByProductPrice", required = false)String productPrice) {
//        if (productName == null || productName.isEmpty()) {
//            List<Order> orderList = orderService.findAll();
//            ModelAndView modelAndView = new ModelAndView("/order/list");
//            modelAndView.addObject("orders", orderList);
//            return modelAndView;
//        }
//        Page<Product> productList = productService.findAllByNameContainingAndPrice(productName, productPrice);
//        List<Order> orderList = orderService.findAllByProductsIn(productList);
//        ModelAndView modelAndView = new ModelAndView("/order/list");
//        modelAndView.addObject("orders", orderList);
//        modelAndView.addObject("search", productName);
//        modelAndView.addObject("search2", productPrice);
//        return modelAndView;
//    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        Order order = orderService.findById(id);
        List<Product> productList = order.getProducts();
        ModelAndView modelAndView = new ModelAndView("/order/view");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Order order = orderService.findById(id);
//        if (order != null) {
//            ModelAndView modelAndView = new ModelAndView("/order/delete");
//            modelAndView.addObject("order", order);
//            return modelAndView;
//        } else {
//            return new ModelAndView("/error.404");
//        }
//    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id) {
        orderService.delete(orderService.findById(id));
        return "redirect:/order/list";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("order") Order order,
                         RedirectAttributes redirectAttributes,
                         @RequestParam(name = "confirmDelete") String confirm) {
        if (confirm.equals("yes")) {
            orderService.delete(order);
            redirectAttributes.addFlashAttribute("message", "Deleting successfully!");
        }
        return "redirect:/order/list";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(name = "searchByName", required = false, defaultValue = "")String name,
                                @RequestParam(name = "fromPrice", required = false, defaultValue = "0")Double fromPrice,
                                @RequestParam(name = "toPrice", required = false, defaultValue = "0")Double toPrice,
                                @RequestParam(name = "fromOrderDate", required = false, defaultValue = "1970/01/01")String fromDate,
                                @RequestParam(name = "toOrderDate", required = false, defaultValue = "2050/12/31")String toDate)
    {
        List<Order> orderList = orderService.findAllBy(name, fromPrice, toPrice, fromDate, toDate);
        ModelAndView modelAndView = new ModelAndView("/order/list");
        modelAndView.addObject("orders", orderList);
        modelAndView.addObject("name", name);
        modelAndView.addObject("fromPrice", fromPrice);
        modelAndView.addObject("toPrice", toPrice);
        modelAndView.addObject("fromOrderDate", fromDate);
        modelAndView.addObject("toOrderDate", toDate);
        return modelAndView;
    }
}
