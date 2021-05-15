package com.codegym.cart.controllers;

import com.codegym.cart.models.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showShoppingCart(@SessionAttribute(name = "cart")Cart cart) {
        return new ModelAndView("/cart/shopping-cart", "cart", cart);
    }
}
