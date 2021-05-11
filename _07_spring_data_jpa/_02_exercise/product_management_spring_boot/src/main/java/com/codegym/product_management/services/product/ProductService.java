package com.codegym.product_management.services.product;

import com.codegym.product_management.models.Product;
import com.codegym.product_management.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllByNameContainingAndPrice(String name, String price, Pageable pageable) {
        return productRepository.findAllByNameContainingAndPrice(name, price, pageable);
    }


//    @Override
//    public List<Product> findAllByNameContainingAndPrice(String name, String price) {
//        return productRepository.findAllByNameContainingAndPrice(name, price);
//    }


    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
