package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Company;
import com.laba.solvd.delivery.persistence.CompanyRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CompanyRepositoryMybatisImpl implements CompanyRepository {

    @Override
    public Company findById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            return companyRepository.findById(8);
        }
    }

    @Override
    public List<Company> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            return companyRepository.retrieveAll();
        }
    }

    @Override
    public void create(Company company) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.create(company);
        }


    }

    @Override
    public void updateCompanyByName(int id, String name) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.updateCompanyByName(id, name);
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);
            companyRepository.deleteById(id);
        }

    }
}
