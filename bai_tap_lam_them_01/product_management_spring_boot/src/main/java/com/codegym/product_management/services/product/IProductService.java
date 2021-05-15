package com.codegym.product_management.services.product;

import com.codegym.product_management.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    //    List<Product> findAllByNameContainingAndPrice(String name, String price);
//    List<Product> findAllByNameContainingAndPriceContaining(String name, String price);

//    Page<Product> findAllByNameContainingAndPrice(String name, String price, Pageable pageable);
//
//    Page<Product> findAllByNameContainingAndPriceContaining(String name, String price, Pageable pageable);
//
//    List<Product> findAllByNameContainingAndPrice(String name, String price);
//    List<Product> findAllByNameContainingAndPriceContaining(String name, String price);

    Page<Product> findAllByNameContainingAndPriceBetween(String name, Double fromPrice,
                                                         Double toPrice, Pageable pageable);

    Product findById(Long id);

    void save(Product product);

    void delete(Product product);

    void deleteById(Long id);
}
