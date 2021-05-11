package com.codegym.product_management.repositories;

import com.codegym.product_management.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
//    List<Product> findAllByNameContainingAndPrice(String name, String price);
    Page<Product> findAllByNameContainingAndPrice(String name, String price, Pageable pageable);
}
