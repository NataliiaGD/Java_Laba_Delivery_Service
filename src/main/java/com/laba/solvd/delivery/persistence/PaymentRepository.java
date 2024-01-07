package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Payment;

import java.util.List;

public interface PaymentRepository {

    List<Payment> retrieveAll();

    void create(Payment payment);

    void deleteById(int id);
}
