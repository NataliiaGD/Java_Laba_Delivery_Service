package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Courier;
import com.laba.solvd.delivery.persistence.CourierRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CourierRepositoryMybatisImpl implements CourierRepository {

    private static final Logger LOGGER = LogManager.getLogger(CourierRepositoryMybatisImpl.class);


    @Override
    public Courier findById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CourierRepository courierRepository = sqlSession.getMapper(CourierRepository.class);
            return courierRepository.findById(4);
        }
    }

    @Override
    public List<Courier> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CourierRepository courierRepository = sqlSession.getMapper(CourierRepository.class);
            return courierRepository.retrieveAll();
        }
    }

    @Override
    public void create(Courier courier) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CourierRepository courierRepository = sqlSession.getMapper(CourierRepository.class);
            courierRepository.create(courier);
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CourierRepository courierRepository = sqlSession.getMapper(CourierRepository.class);
            courierRepository.deleteById(id);
        }
    }
}
