package com.codegym.demo.services;

import com.codegym.demo.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    Customer save(Customer customer);

    void delete(Customer customer);


}
