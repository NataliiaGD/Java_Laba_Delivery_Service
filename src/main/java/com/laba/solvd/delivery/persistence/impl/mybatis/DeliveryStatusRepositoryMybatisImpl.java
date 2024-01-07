package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.DeliveryStatus;
import com.laba.solvd.delivery.persistence.DeliveryStatusRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeliveryStatusRepositoryMybatisImpl implements DeliveryStatusRepository {

    @Override
    public List<DeliveryStatus> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DeliveryStatusRepository deliveryStatusRepository = sqlSession.getMapper(DeliveryStatusRepository.class);
            return deliveryStatusRepository.retrieveAll();
        }
    }

    @Override
    public void create(DeliveryStatus status) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DeliveryStatusRepository deliveryStatusRepository = sqlSession.getMapper(DeliveryStatusRepository.class);
            deliveryStatusRepository.create(status);
        }

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DeliveryStatusRepository deliveryStatusRepository = sqlSession.getMapper(DeliveryStatusRepository.class);
            deliveryStatusRepository.deleteById(id);
        }

    }
}
