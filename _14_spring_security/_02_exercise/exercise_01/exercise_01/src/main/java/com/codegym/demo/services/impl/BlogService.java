package com.codegym.demo.services.impl;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Category;
import com.codegym.demo.repositories.IBlogRepository;
import com.codegym.demo.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

//    @Override
//    public List<Blog> findAll() {
//        return blogRepository.findAll();
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
//        Pageable sortedByName = PageRequest.of(0, 3, Sort.by("name"));
//        Pageable pageable1 = PageRequest.of(0, 3);
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public List<Blog> findAllByCategoriesContains(Category category) {
        return blogRepository.findAllByCategoriesContains(category);
    }
}
