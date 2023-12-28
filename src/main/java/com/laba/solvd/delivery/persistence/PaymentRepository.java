package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Payment;

import java.util.List;

public interface PaymentRepository {
    Payment findById(int id);

    List<Payment> retrieveAll();

    void create(Payment payment);

    void updatePaymentByPaymentDetails(int id, String newPaymentDetails);

    void deleteById(int id);
}
