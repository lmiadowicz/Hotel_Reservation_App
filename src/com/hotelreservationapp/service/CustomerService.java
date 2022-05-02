package com.hotelreservationapp.service;

import com.hotelreservationapp.model.Customer;

import java.util.*;

public class CustomerService {
    private static CustomerService INSTANCE;
    private Set<Customer> customers;

    private CustomerService() {}

    public static CustomerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerService();
            INSTANCE.customers = new HashSet<>();
        }
        return INSTANCE;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        Customer newCustomer = new Customer(email, firstName, lastName);
        if (customers.contains(newCustomer)) {
            System.out.println("Error: Email " + email + " already added.");
            return;
        }
        customers.add(newCustomer);
    }
    public Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getEmail(), customerEmail))
                return customer;
        }
        return null;
    }
    public Collection<Customer> getAllCustomers() {
        return customers;
    }

}

