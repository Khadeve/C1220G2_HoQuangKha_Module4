package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerList();
    Customer getCustomerById(int id);
}
