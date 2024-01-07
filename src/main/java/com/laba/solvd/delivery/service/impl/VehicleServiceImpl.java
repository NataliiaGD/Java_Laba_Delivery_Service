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
    public List<Vehicle> retrieveAll() {
        List<Vehicle> vehicles = vehicleRepository.retrieveAll();
        return vehicles;
    }

    @Override
    public void create(Vehicle vehicle) {
        vehicleRepository.create(vehicle);
    }

    @Override
    public void deleteById(int id) {
        vehicleRepository.deleteById(id);

    }
}
