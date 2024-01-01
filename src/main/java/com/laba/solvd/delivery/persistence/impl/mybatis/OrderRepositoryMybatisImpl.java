package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Order;
import com.laba.solvd.delivery.persistence.OrderRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderRepositoryMybatisImpl implements OrderRepository {
    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            return orderRepository.retrieveAll();
        }
    }

    @Override
    public void create(Order order) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            orderRepository.create(order);
        }
    }

    @Override
    public void updateOrderByOrderDetails(int id, String newOrderDetails) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
            orderRepository.deleteById(id);
        }

    }
}
