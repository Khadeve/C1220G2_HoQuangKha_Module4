package com.example.demo.services;

import com.example.demo.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> findAll(int offset, int rowCount);

    Blog findById(Long id);

    void save(Blog blog);

    void delete(Blog blog);

    List<Blog> findAllByNameContaining(String name);

    Page<Blog> findAll(Pageable pageable);
}
