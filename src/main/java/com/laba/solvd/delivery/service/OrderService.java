package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Order;

import java.util.List;

public interface OrderService {
    Order findById(int id);

    List<Order> retrieveAll();

    void create(Order order);

    void updateOrderByOrderDetails(int id, String newOrderDetails);

    void deleteById(int id);
}
