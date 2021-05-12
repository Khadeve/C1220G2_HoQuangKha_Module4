package com.codegym.demo.controllers;

import com.codegym.demo.models.Blog;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showListBlog(@PageableDefault(value = 3) @SortDefault(sort = "madeTime", direction = Sort.Direction.DESC) Pageable pageable,
                                     @RequestParam(name = "byName", required = false)String searchByName) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Blog> blogList = null;
        if (searchByName == null || searchByName.isEmpty()) {
            blogList = blogService.findAll(pageable);
        } else {
            blogList = blogService.findAllByNameContaining(searchByName, pageable);
        }
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("search", searchByName);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public String createNewBlog(@ModelAttribute(name = "blog") Blog blog,
                                RedirectAttributes redirectAttributes)
    {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Add new blog successfully!");
        return "redirect:/create-blog";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView showBlogDetail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("view", "blog", blog);
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteConfirm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("delete-confirm", "blog", blog);
    }

    @PostMapping("/confirm-delete")
    public String confirmDelete(@ModelAttribute Blog blog,
                                      @RequestParam(name = "confirmDelete") String confirm,
                                      RedirectAttributes redirectAttributes)
    {
        if (confirm.equals("Accept")) {
            blogService.delete(blog);
            redirectAttributes.addFlashAttribute("deleteMessage", "Delete blog successfully!");
        } else {
            redirectAttributes.addFlashAttribute("deleteMessage", "Cancel delete");
        }
        return "redirect:/";
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }
        return new ModelAndView("/error.404");
    }

    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute(name = "blog") Blog newBlog) {
        blogService.save(newBlog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", newBlog);
        modelAndView.addObject("editMessage", "Update successfully!");
        return modelAndView;
    }

//    @GetMapping("/search-blog")
//    public ModelAndView findAllByNameContaining(@RequestParam(name = "byName")String byName,
//                                                @PageableDefault(value = 3)Pageable pageable,
//                                                @RequestParam(name = "counter", required = false, defaultValue = "3")String counter)
//    {
//        Page<Blog> blogList = blogService.findAllByNameContaining(byName, pageable);
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("blogs", blogList);
//        modelAndView.addObject("search", byName);
//        return modelAndView;
//    }
}
