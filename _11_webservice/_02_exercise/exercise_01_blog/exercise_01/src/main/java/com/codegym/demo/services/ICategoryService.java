package com.codegym.demo.services;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Category category);

    List<Category> findAllWithBlogId(Long blogId);

}
