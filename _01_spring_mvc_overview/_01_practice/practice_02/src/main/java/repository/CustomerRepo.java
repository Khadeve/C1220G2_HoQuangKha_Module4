package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> getCustomerList();
    Customer getCustomerById(int id);
}
