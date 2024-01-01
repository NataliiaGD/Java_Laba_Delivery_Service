package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Discount;
import com.laba.solvd.delivery.persistence.DiscountRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DiscountRepositoryMybatisImpl implements DiscountRepository {
    @Override
    public Discount findById(int id) {
        return null;
    }

    @Override
    public List<Discount> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DiscountRepository discountRepository = sqlSession.getMapper(DiscountRepository.class);
            return discountRepository.retrieveAll();
        }
    }

    @Override
    public void create(Discount discount) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DiscountRepository discountRepository = sqlSession.getMapper(DiscountRepository.class);
            discountRepository.create(discount);
        }
    }

    @Override
    public void updateDiscountByDiscountAmount(int id, String newDiscountAmount) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            DiscountRepository discountRepository = sqlSession.getMapper(DiscountRepository.class);
            discountRepository.deleteById(id);
        }

    }
}
