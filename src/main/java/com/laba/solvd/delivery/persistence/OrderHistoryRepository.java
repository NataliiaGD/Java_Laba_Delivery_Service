package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.OrderHistory;

import java.util.List;

public interface OrderHistoryRepository {

    List<OrderHistory> retrieveAll();

    void create(OrderHistory orderHistory);

    void deleteById(int id);
}
