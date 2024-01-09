package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> retrieveAll();

    void create(Order order);

    void deleteById(int id);
}
