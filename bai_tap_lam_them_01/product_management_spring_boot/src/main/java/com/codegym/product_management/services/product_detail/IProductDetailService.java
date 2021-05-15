package com.codegym.product_management.services.product_detail;

import com.codegym.product_management.models.ProductDetail;

import java.util.List;

public interface IProductDetailService {
    List<ProductDetail> findAll();
    ProductDetail findById(Long id);
    void save(ProductDetail productDetail);
    void delete(ProductDetail productDetail);
}
