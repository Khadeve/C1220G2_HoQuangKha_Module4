package com.codegym.demo.controllers;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Category;
import com.codegym.demo.services.IBlogService;
import com.codegym.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> list() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/blogsWithCategory/{id}")
    public ResponseEntity<List<Blog>> blogList(@PathVariable(name = "id")Long id) {
        Category category = categoryService.findById(id);
        List<Blog> blogList = blogService.findAllByCategoriesContains(category);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
