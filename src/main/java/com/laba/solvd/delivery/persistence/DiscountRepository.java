package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Discount;

import java.util.List;

public interface DiscountRepository {
    Discount findById(int id);

    List<Discount> retrieveAll();

    void create(Discount discount);

    void updateDiscountByDiscountAmount(int id, String newDiscountAmount);

    void deleteById(int id);
}
