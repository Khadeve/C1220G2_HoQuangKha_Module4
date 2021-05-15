package com.codegym.product_management.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacture;
    private String productionDate;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id", referencedColumnName = "id")
    private ProductDetail productDetail;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product() {
    }

    public Product(Category category, ProductDetail productDetail) {
        this.category = category;
        this.productDetail = productDetail;
    }

    public Product(String name, String manufacture, String productionDate, Double price, Category category, ProductDetail productDetail) {
        this.name = name;
        this.manufacture = manufacture;
        this.productionDate = productionDate;
        this.category = category;
        this.productDetail = productDetail;
        this.price = price;
    }

    public Product(String name, String manufacture, String productionDate, Double price, Category category, ProductDetail productDetail, List<Order> orders) {
        this.name = name;
        this.manufacture = manufacture;
        this.productionDate = productionDate;
        this.category = category;
        this.productDetail = productDetail;
        this.orders = orders;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getManufacture(), product.getManufacture()) &&
                Objects.equals(getProductionDate(), product.getProductionDate()) &&
                getCategory().equals(product.getCategory()) &&
                getProductDetail().equals(product.getProductDetail()) &&
                Objects.equals(getOrders(), product.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getManufacture(), getProductionDate(), getCategory(), getProductDetail(), getOrders());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
