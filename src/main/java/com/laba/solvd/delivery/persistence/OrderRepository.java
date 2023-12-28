package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Order;

import java.util.List;

public interface OrderRepository {
    Order findById(int id);

    List<Order> retrieveAll();

    void create(Order order);

    void updateOrderByOrderDetails(int id, String newOrderDetails);

    void deleteById(int id);
}
