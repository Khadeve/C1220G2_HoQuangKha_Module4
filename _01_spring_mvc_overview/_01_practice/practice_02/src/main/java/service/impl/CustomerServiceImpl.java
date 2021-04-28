package service.impl;

import model.Customer;
import repository.CustomerRepo;
import repository.impl.CustomerRepoImpl;
import service.CustomerService;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo = new CustomerRepoImpl();

    @Override
    public List<Customer> getCustomerList() {
        return customerRepo.getCustomerList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepo.getCustomerById(id);
    }
}
