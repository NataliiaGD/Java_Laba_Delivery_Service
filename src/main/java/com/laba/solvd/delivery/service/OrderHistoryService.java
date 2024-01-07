package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> retrieveAll();

    void create(OrderHistory orderHistory);

    void deleteById(int id);
}
