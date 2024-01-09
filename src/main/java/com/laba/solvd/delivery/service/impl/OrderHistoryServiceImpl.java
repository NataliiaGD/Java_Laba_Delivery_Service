package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.OrderHistory;
import com.laba.solvd.delivery.persistence.OrderHistoryRepository;
import com.laba.solvd.delivery.service.OrderHistoryService;

import java.util.List;

public class OrderHistoryServiceImpl implements OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    @Override
    public List<OrderHistory> retrieveAll() {
        List<OrderHistory> orderHistories = orderHistoryRepository.retrieveAll();
        return orderHistories;
    }

    @Override
    public void create(OrderHistory orderHistory) {
        orderHistoryRepository.create(orderHistory);
    }

    @Override
    public void deleteById(int id) {
        orderHistoryRepository.deleteById(id);

    }
}
