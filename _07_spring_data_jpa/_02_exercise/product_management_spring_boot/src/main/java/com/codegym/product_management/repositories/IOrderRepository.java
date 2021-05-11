package com.codegym.product_management.repositories;

import com.codegym.product_management.models.Order;
import com.codegym.product_management.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByProductsIn(Page<Product> productList);
}
