package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Vehicle;
import com.laba.solvd.delivery.persistence.VehicleRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class VehicleRepositoryMybatisImpl implements VehicleRepository {
    @Override
    public Vehicle findById(int id) {
        return null;
    }

    @Override
    public List<Vehicle> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            VehicleRepository vehicleRepository = sqlSession.getMapper(VehicleRepository.class);
            return vehicleRepository.retrieveAll();
        }
    }

    @Override
    public void create(Vehicle vehicle) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            VehicleRepository vehicleRepository = sqlSession.getMapper(VehicleRepository.class);
            vehicleRepository.create(vehicle);
        }

    }

    @Override
    public void updateVehicleByVehicleType(int id, String newVehicleType) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            VehicleRepository vehicleRepository = sqlSession.getMapper(VehicleRepository.class);
            vehicleRepository.deleteById(id);
        }

    }
}
