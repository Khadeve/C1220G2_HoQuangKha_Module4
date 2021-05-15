package com.codegym.product_management.repositories;

import com.codegym.product_management.models.Order;
import com.codegym.product_management.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();

    @Query(
            value = "SELECT * FROM orders o " +
                    "INNER JOIN products_orders po ON o.id = po.order_id " +
                    "INNER JOIN products p ON p.id = po.product_id " +
                    "WHERE ((p.`name` LIKE %?1%) AND " +
                    "(p.price BETWEEN ?2 AND ?3) AND " +
                    "(o.order_date BETWEEN ?4 AND ?5)) " +
                    "GROUP BY o.id", nativeQuery = true
    )
    List<Order> findAllBy(String name, Double fromPrice, Double toPrice, String fromOrderDate, String toOrderDate);
}
