package com.codegym.demo.services;

import com.codegym.demo.models.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Blog blog);
}
