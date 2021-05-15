package com.codegym.product_management.repositories;

import com.codegym.product_management.models.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
