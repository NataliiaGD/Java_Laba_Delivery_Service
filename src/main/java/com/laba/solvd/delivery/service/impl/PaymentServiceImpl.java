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
    public List<Payment> retrieveAll() {
        List<Payment> payments = paymentRepository.retrieveAll();
        return payments;
    }

    @Override
    public void create(Payment payment) {
        paymentRepository.create(payment);
    }

    @Override
    public void deleteById(int id) {
        paymentRepository.deleteById(id);

    }
}
