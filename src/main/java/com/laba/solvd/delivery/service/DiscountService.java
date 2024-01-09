package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> retrieveAll();

    void create(Discount discount);

    void deleteById(int id);
}
