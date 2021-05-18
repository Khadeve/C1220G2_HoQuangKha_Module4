package com.example.demo.controllers;

import com.example.demo.models.Blog;
import com.example.demo.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogService.findAll());
        return modelAndView;
    }

//    @GetMapping("/search/{keyword}")
//    public ResponseEntity<List<Blog>> searchByName(@PathVariable String keyword) {
//        List<Blog> blogList = blogService.findAllByNameContaining(keyword);
////        if (blogList.isEmpty()) {
////            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchByName(@RequestParam(name = "keyword", defaultValue = "")String keyword) {
        List<Blog> blogList = blogService.findAllByNameContaining(keyword);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/paginate")
    public ModelAndView showBlogList() {
        int rowCount = 2, offset = 0;
        List<Blog> blogList = blogService.findAll(offset, rowCount);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogList);
        modelAndView.addObject("offset", offset);
        return modelAndView;
    }

    @GetMapping("/load-more")
    public ResponseEntity<List<Blog>> loadMore(@RequestParam(name = "offset")Integer offset) {
        List<Blog> blogList = blogService.findAll(offset, 2);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
