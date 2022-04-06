package com.hotelreservationapp.service;

import com.hotelreservationapp.model.Customer;
import java.util.Collection;
import java.util.HashMap;

public class CustomerService {
    private static CustomerService INSTANCE;
    private HashMap<String, Customer> customers;

    private CustomerService() {}

    public static CustomerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerService();
            INSTANCE.customers = new HashMap<>();
        }
        return INSTANCE;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        customers.put(email, new Customer(email, firstName, lastName));
    }
    public Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }
    public Collection<Customer> getAllCustomers() {
        return (Collection<Customer>) customers;
    }
}

