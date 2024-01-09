package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> retrieveAll();

    void create(Customer customer);

    void deleteById(int id);
}
