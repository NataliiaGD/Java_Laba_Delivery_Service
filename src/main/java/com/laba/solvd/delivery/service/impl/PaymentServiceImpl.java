package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Payment;
import com.laba.solvd.delivery.persistence.PaymentRepository;
import com.laba.solvd.delivery.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(int id) {
        return null;
    }

    @Override
    public List<Payment> retrieveAll() {
        return null;
    }

    @Override
    public void create(Payment payment) {
        paymentRepository.create(payment);
    }

    @Override
    public void updatePaymentByPaymentDetails(int id, String newPaymentDetails) {

    }

    @Override
    public void deleteById(int id) {
        paymentRepository.deleteById(id);

    }
}
