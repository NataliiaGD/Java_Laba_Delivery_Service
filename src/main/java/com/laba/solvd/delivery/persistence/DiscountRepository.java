package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Discount;

import java.util.List;

public interface DiscountRepository {

    List<Discount> retrieveAll();

    void create(Discount discount);

    void deleteById(int id);
}
