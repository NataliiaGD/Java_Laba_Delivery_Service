package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(int id);

    List<Customer> retrieveAll();

    void create(Customer customer);

    void updateCustomerByFirstName(int id, String newFirstName);

    void deleteById(int id);
}
