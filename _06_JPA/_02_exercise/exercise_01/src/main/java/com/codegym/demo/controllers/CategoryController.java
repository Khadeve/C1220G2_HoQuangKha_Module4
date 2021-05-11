package com.codegym.demo.controllers;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Category;
import com.codegym.demo.services.IBlogService;
import com.codegym.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "Add successfully!");
        return modelAndView;
    }

    @GetMapping("/categories")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categories", categoryList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editCategory(@ModelAttribute Category category, @RequestParam String confirmEdit)
    {
        if (confirmEdit.equals("accept")) {
            categoryService.save(category);
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category);
            modelAndView.addObject("message", "Edit successfully!");
            return modelAndView;
        }
        return showList();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView confirmDelete(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteCategory(@ModelAttribute Category category,
                                      @RequestParam(name = "confirmDelete") String confirm)
    {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        if (confirm.equals("yes")) {
            categoryService.delete(category);
            modelAndView.addObject("message", "Delete successfully!");
        }
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showBlogsWithCategory(@PathVariable(name = "id") Long id)
    {
        Category category = categoryService.findById(id);
        List<Blog> blogList = blogService.findAllByCategoriesContains(category);
        ModelAndView modelAndView = new ModelAndView("/category/blogsWithCategory");
        modelAndView.addObject("category", category);
        modelAndView.addObject("blogs", blogList);
        return modelAndView;
    }
}
