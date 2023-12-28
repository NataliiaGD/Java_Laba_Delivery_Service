package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Order;
import com.laba.solvd.delivery.persistence.OrderRepository;
import com.laba.solvd.delivery.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> retrieveAll() {
        return null;
    }

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public void updateOrderByOrderDetails(int id, String newOrderDetails) {

    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);

    }
}
