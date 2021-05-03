package com.codegym.repositories;

import com.codegym.models.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
