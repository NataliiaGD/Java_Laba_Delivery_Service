package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Vehicle;
import com.laba.solvd.delivery.persistence.VehicleRepository;
import com.laba.solvd.delivery.service.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle findById(int id) {
        return null;
    }

    @Override
    public List<Vehicle> retrieveAll() {
        return null;
    }

    @Override
    public void create(Vehicle vehicle) {

    }

    @Override
    public void updateVehicleByVehicleType(int id, String newVehicleType) {

    }

    @Override
    public void deleteById(int id) {
        vehicleRepository.deleteById(id);

    }
}
