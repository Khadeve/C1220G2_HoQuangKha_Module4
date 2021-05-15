package com.codegym.demo.controllers;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.BlogDetail;
import com.codegym.demo.models.Category;
import com.codegym.demo.services.IBlogService;
import com.codegym.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> list() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<BlogDetail> detail(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findAllWithBlogId(id);
        BlogDetail blogDetail = new BlogDetail(blog, categoryList);
        if (blogDetail.getBlog() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogDetail, HttpStatus.OK);
    }
}
