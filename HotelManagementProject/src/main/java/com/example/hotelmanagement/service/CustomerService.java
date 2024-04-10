package com.example.hotelmanagement.service;

import com.example.hotelmanagement.model.Customer;
import com.example.hotelmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Method to add a new customer
    public Customer addCustomer(Customer customer) {
        // Any business logic before saving the customer
        return customerRepository.save(customer);
    }


    // Additional methods as required for business logic can be added here
}
