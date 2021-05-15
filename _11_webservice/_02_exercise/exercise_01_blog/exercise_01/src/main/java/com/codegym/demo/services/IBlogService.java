package com.codegym.demo.services;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Blog blog);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    List<Blog> findAllByCategoriesContains(Category category);

    Blog findDetailBlog(Long id);
}
