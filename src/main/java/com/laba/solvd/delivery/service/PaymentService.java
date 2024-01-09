package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> retrieveAll();

    void create(Payment payment);

    void deleteById(int id);
}
