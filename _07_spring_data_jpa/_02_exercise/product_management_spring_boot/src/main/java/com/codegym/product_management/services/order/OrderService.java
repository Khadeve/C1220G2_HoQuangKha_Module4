package com.codegym.product_management.services.order;

import com.codegym.product_management.models.Order;
import com.codegym.product_management.models.Product;
import com.codegym.product_management.repositories.IOrderRepository;
import com.codegym.product_management.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findAllByProductsIn(Page<Product> productList) {
        return orderRepository.findAllByProductsIn(productList);
    }
}
