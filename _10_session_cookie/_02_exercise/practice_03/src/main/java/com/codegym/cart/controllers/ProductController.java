package com.codegym.cart.controllers;

import com.codegym.cart.models.Cart;
import com.codegym.cart.models.Product;
import com.codegym.cart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(@PageableDefault(value = 3)Pageable pageable)
    {
        return new ModelAndView("/product/shop",
                "products", productService.findAll(pageable));
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable(name = "id")Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public ModelAndView addToCart(@SessionAttribute(name = "cart")Cart cart,
                                  @PathVariable(name = "id")Long id,
                                  @RequestParam(name = "action", required = false)String action)
    {
        Product product = productService.findById(id);
        if ("show".equals(action)) {
            cart.addProduct(product);
            return new ModelAndView("/cart/shopping-cart");
        }
        cart.addProduct(product);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "successfully");
        return modelAndView;
    }

//    @GetMapping("/add/{id}")
//    public ModelAndView addToCart(@ModelAttribute(name = "cart")Cart cart,
//                                  @RequestParam(name = "action")String action,
//                                  @PathVariable(name = "id")Long id)
//    {
//        Product product = productService.findById(id);
//        if (product == null) {
//            return new ModelAndView("/error.404");
//        }
//        if (action.equals("show")) {
//            cart.addProduct(product);
//            return new ModelAndView("/cart/shopping-cart");
//        }
//        cart.addProduct(product);
//        ModelAndView modelAndView = new ModelAndView("/product/shop");
//        modelAndView.addObject("products", productService.findAll());
//        modelAndView.addObject("message", "Adding successfully!");
//        return modelAndView;
//    }

    @GetMapping("/minus/{id}")
    public ModelAndView minusFromCart(@ModelAttribute(name = "cart")Cart cart,
                                        @PathVariable(name = "id")Long id)
    {
        Product product = productService.findById(id);
        if (product == null) {
            return new ModelAndView("/error.404");
        }
        cart.minusProduct(product);
        return new ModelAndView("/cart/shopping-cart");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeFromCart(@PathVariable(name = "id")Long id,
                                       @SessionAttribute(name = "cart")Cart cart)
    {
        Product product = productService.findById(id);
        if (product == null) {
            return new ModelAndView("/error.404");
        }
        cart.removeProduct(product);
        return new ModelAndView("/cart/shopping-cart");
    }
}
