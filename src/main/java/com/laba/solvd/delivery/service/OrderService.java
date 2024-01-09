package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> retrieveAll();

    void create(Order order);

    void deleteById(int id);
}
