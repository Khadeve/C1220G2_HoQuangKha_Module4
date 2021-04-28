package repository.impl;

import model.Customer;
import repository.CustomerRepo;

import java.util.*;

public class CustomerRepoImpl implements CustomerRepo {
    private static Map<Integer, Customer> customerDb = new HashMap<>();

    static {
        customerDb.put(1, new Customer(1, "Khang Ho", "khangho@gmail.com", "Quy Nhon"));
        customerDb.put(2, new Customer(2, "Kha Ho", "khaho@gmail.com", "Da Nang"));
        customerDb.put(3, new Customer(3, "Hoai Do", "hoaido@gmail.com", "Quy Nhon"));
        customerDb.put(4, new Customer(4, "Nhan Truong", "nhantruong@gmail.com", "Quy Nhon"));
        customerDb.put(5, new Customer(5, "Ai Nu", "ainu@gmail.com", "Quy Nhon"));
    }

    @Override
    public List<Customer> getCustomerList() {
        return new ArrayList<>(customerDb.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        List<Customer> customers = getCustomerList();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
