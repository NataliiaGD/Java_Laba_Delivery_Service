package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Customer;
import com.laba.solvd.delivery.persistence.CustomerRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustomerRepositoryMybatisImpl implements CustomerRepository {
    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            return customerRepository.retrieveAll();
        }
    }

    @Override
    public void create(Customer customer) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.create(customer);
        }

    }

    @Override
    public void updateCustomerByFirstName(int id, String newFirstName) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.deleteById(id);
        }
    }
}
