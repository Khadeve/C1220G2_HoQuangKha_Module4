package com.codegym.cart.services;

import com.codegym.cart.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    Page<Product> findAll(Pageable pageble);

}
