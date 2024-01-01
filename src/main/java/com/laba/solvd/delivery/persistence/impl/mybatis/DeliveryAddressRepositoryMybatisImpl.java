package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.DeliveryAddress;
import com.laba.solvd.delivery.persistence.DeliveryAddressRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeliveryAddressRepositoryMybatisImpl implements DeliveryAddressRepository {
    @Override
    public DeliveryAddress findById(int id) {
        return null;
    }

    @Override
    public List<DeliveryAddress> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DeliveryAddressRepository deliveryAddressRepository = sqlSession.getMapper(DeliveryAddressRepository.class);
            return deliveryAddressRepository.retrieveAll();
        }
    }

    @Override
    public void create(DeliveryAddress address) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DeliveryAddressRepository deliveryAddressRepository = sqlSession.getMapper(DeliveryAddressRepository.class);
            deliveryAddressRepository.create(address);
        }

    }

    @Override
    public void updateDeliveryAddressByAddress(int id, String newAddress) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DeliveryAddressRepository deliveryAddressRepository = sqlSession.getMapper(DeliveryAddressRepository.class);
            deliveryAddressRepository.deleteById(id);
        }

    }
}
