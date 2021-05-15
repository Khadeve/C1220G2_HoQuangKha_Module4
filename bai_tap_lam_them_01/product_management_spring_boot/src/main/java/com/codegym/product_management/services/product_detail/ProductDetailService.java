package com.codegym.product_management.services.product_detail;

import com.codegym.product_management.models.ProductDetail;
import com.codegym.product_management.repositories.IProductDetailRepository;
import com.codegym.product_management.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    private IProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetail findById(Long id) {
        return productDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void delete(ProductDetail productDetail) {
        productDetailRepository.delete(productDetail);
    }
}
