package com.example.demo.services;


import com.example.demo.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    Category removeById(Long id);

}
