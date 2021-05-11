package com.codegym.management.services.customer;

import com.codegym.management.models.Customer;
import com.codegym.management.models.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
//    List<Customer> findAll();
    Customer findById(Long id) throws Exception;
    void save(Customer customer);
    void delete(Customer customer);
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
