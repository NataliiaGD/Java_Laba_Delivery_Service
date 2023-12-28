package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer findById(int id);

    List<Customer> retrieveAll();

    void create(Customer customer);

    void updateCustomerByFirstName(int id, String newFirstName);

    void deleteById(int id);
}
