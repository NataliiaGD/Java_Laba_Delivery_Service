package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.OrderHistory;
import com.laba.solvd.delivery.persistence.OrderHistoryRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderHistoryRepositoryMybatisImpl implements OrderHistoryRepository {

    @Override
    public List<OrderHistory> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            OrderHistoryRepository orderHistoryRepository = sqlSession.getMapper(OrderHistoryRepository.class);
            return orderHistoryRepository.retrieveAll();
        }
    }

    @Override
    public void create(OrderHistory orderHistory) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            OrderHistoryRepository orderHistoryRepository = sqlSession.getMapper(OrderHistoryRepository.class);
            orderHistoryRepository.create(orderHistory);
        }

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            OrderHistoryRepository orderHistoryRepository = sqlSession.getMapper(OrderHistoryRepository.class);
            orderHistoryRepository.deleteById(id);
        }

    }
}
