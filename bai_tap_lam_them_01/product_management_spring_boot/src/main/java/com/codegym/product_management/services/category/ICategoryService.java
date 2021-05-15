package com.codegym.product_management.services.category;

import com.codegym.product_management.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
}
