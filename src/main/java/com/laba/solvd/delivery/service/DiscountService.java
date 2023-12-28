package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Discount;

import java.util.List;

public interface DiscountService {
    Discount findById(int id);

    List<Discount> retrieveAll();

    void create(Discount discount);

    void updateDiscountByDiscountAmount(int id, String newDiscountAmount);

    void deleteById(int id);
}
