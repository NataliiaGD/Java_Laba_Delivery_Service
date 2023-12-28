package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Payment;

import java.util.List;

public interface PaymentService {
    Payment findById(int id);

    List<Payment> retrieveAll();

    void create(Payment payment);

    void updatePaymentByPaymentDetails(int id, String newPaymentDetails);

    void deleteById(int id);
}
