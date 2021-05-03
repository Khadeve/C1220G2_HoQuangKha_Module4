package com.codegym.repositories;

import com.codegym.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo implements IProductRepo {

    private static Map<Integer, Product> productListDb;

    static {
        productListDb = new HashMap<>();

        productListDb.put(1, new Product(1, "Iphone1", 1000, "Luxury", "Apple"));
        productListDb.put(2, new Product(2, "Iphone2", 1000, "Luxury", "Apple"));
        productListDb.put(3, new Product(3, "Iphone3", 1000, "Luxury", "Apple"));
        productListDb.put(4, new Product(4, "Iphone4", 1000, "Luxury", "Apple"));
        productListDb.put(5, new Product(5, "Iphone5", 1000, "Luxury", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productListDb.values());
    }

    @Override
    public void save(Product product) {
        productListDb.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productListDb.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productListDb.replace(id, product);
    }

    @Override
    public void remove(int id) {
        productListDb.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Map.Entry<Integer, Product> product : productListDb.entrySet()) {
            if (product.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product.getValue());
            }
        }
        return result;
    }
}
