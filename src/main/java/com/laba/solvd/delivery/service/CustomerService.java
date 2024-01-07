package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> retrieveAll();

    void create(Customer customer);

    void deleteById(int id);
}
