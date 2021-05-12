package com.codegym.management.services.customer;

import com.codegym.management.models.Customer;
import com.codegym.management.models.Province;
import com.codegym.management.repositories.ICustomerRepository;
import com.codegym.management.services.util.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

//    @Override
//    public List<Customer> findAll() {
//        return customerRepository.findAll();
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
//        test aop @AfterThrowing advice
//        if (true) throw new Exception("a dummy exception!");
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) throws Exception {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new Exception("Customer not found!");
        }
        return customer;
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException("Email must be distinct");
        }

    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(firstName, pageable);
    }
}
