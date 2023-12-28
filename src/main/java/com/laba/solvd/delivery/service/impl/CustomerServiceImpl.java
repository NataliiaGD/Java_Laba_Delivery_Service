package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Customer;
import com.laba.solvd.delivery.persistence.CustomerRepository;
import com.laba.solvd.delivery.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> retrieveAll() {
        return null;
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public void updateCustomerByFirstName(int id, String newFirstName) {

    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
