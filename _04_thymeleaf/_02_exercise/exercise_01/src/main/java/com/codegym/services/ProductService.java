package com.codegym.services;

import com.codegym.models.Product;
import com.codegym.repositories.IProductRepo;
import com.codegym.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
//    private ProductRepo productRepo;
    private IProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepo.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }
}
