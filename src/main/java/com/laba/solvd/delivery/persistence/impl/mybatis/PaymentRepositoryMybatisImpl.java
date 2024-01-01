package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Payment;
import com.laba.solvd.delivery.persistence.PaymentRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaymentRepositoryMybatisImpl implements PaymentRepository {
    @Override
    public Payment findById(int id) {
        return null;
    }

    @Override
    public List<Payment> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            PaymentRepository paymentRepository = sqlSession.getMapper(PaymentRepository.class);
            return paymentRepository.retrieveAll();
        }
    }

    @Override
    public void create(Payment payment) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            PaymentRepository paymentRepository = sqlSession.getMapper(PaymentRepository.class);
            paymentRepository.create(payment);
        }

    }

    @Override
    public void updatePaymentByPaymentDetails(int id, String newPaymentDetails) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            PaymentRepository paymentRepository = sqlSession.getMapper(PaymentRepository.class);
            paymentRepository.deleteById(id);
        }

    }
}
