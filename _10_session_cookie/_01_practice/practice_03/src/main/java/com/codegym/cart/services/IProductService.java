package com.codegym.cart.services;

import com.codegym.cart.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
