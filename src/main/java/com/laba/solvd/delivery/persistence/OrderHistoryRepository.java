package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.OrderHistory;

import java.util.List;

public interface OrderHistoryRepository {
    OrderHistory findById(int id);

    List<OrderHistory> retrieveAll();

    void create(OrderHistory orderHistory);

    void deleteById(int id);
}
