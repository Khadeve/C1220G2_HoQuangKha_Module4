package com.codegym.cart.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkProductInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void minusProduct(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        assert itemEntry != null;
        if (itemEntry.getValue() > 0) {
            Integer newQuantity = itemEntry.getValue() - 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void addProduct(Product product) {
        if (!checkProductInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            assert itemEntry != null;
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Double calTotalPayment() {
        double totalPayment = 0.0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int amount = entry.getValue();
            totalPayment += product.getPrice() * amount;
        }
        return totalPayment;
    }

    public boolean removeProduct(Product product) {
        boolean check = checkProductInCart(product);
        if (check) {
            products.remove(product);
        }
        return check;
    }
}
