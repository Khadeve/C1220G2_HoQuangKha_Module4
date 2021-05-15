package com.codegym.product_management.services.order;

import com.codegym.product_management.models.Order;
import com.codegym.product_management.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    Order findById(Long id);

    void save(Order order);

    void delete(Order order);

    //    List<Order> findAllByProductsIn(Page<Product> productList);
    List<Order> findAllBy(String name, Double fromPrice, Double toPrice,
                          String fromOrderDate, String toOrderDate);

}
