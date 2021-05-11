package com.codegym.product_management.controllers;

import com.codegym.product_management.models.Category;
import com.codegym.product_management.models.Order;
import com.codegym.product_management.models.Product;
import com.codegym.product_management.services.category.ICategoryService;
import com.codegym.product_management.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "Creating successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list(@PageableDefault(value = 1) Pageable pageable) {
        Page<Product> productList = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(name = "searchByName", required = false) String productName,
                               @RequestParam(name = "searchByProductPrice", required = false)String productPrice,
                               @PageableDefault(value = 1)Pageable pageable)
    {
        if (productName == null || productName.isEmpty()) {
            List<Product> productList = productService.findAll();
            ModelAndView modelAndView = new ModelAndView("/product/list");
            modelAndView.addObject("products", productList);
            return modelAndView;
        }
        Page<Product> productList = productService.findAllByNameContainingAndPrice(productName, productPrice, pageable);
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productList);
        modelAndView.addObject("search", productName);
        modelAndView.addObject("search2", productPrice);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            return new ModelAndView("/product/edit", "product", product);
        }
        return new ModelAndView("/error.404");
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("product") Product product,
                                       @RequestParam String confirmEdit,
                             @PageableDefault(value = 1)Pageable pageable)
    {
        if (confirmEdit.equals("accept")) {
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
            productService.save(product);
            modelAndView.addObject("message", "Updating successfully");
            return modelAndView;
        }
        return new ModelAndView("/product/list", "products", productService.findAll(pageable));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product")Product product,
                         RedirectAttributes redirectAttributes,
                         @RequestParam(name = "confirmDelete")String confirm)
    {
        if (confirm.equals("yes")) {
            productService.delete(product);
            redirectAttributes.addFlashAttribute("message", "Deleting successfully!");
        }
        return "redirect:/product/list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable(name = "id")Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/view")
    public ModelAndView view(@ModelAttribute(name = "product")Product product,
                             @RequestParam(name = "choice")String userChoice,
                             @PageableDefault(value = 1) Pageable pageable)
    {
        if (userChoice.equals("edit")) {
            return new ModelAndView("/product/edit", "product", product);
        } else {
            return new ModelAndView("/product/list", "products", productService.findAll(pageable));
        }
    }
}
