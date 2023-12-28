package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Discount;
import com.laba.solvd.delivery.persistence.DiscountRepository;
import com.laba.solvd.delivery.service.DiscountService;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Discount findById(int id) {
        return null;
    }

    @Override
    public List<Discount> retrieveAll() {
        return null;
    }

    @Override
    public void create(Discount discount) {
        discountRepository.create(discount);
    }

    @Override
    public void updateDiscountByDiscountAmount(int id, String newDiscountAmount) {

    }

    @Override
    public void deleteById(int id) {
        discountRepository.deleteById(id);
    }
}
