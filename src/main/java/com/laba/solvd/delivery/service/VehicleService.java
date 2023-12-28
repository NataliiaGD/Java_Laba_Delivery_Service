package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle findById(int id);

    List<Vehicle> retrieveAll();

    void create(Vehicle vehicle);

    void updateVehicleByVehicleType(int id, String newVehicleType);

    void deleteById(int id);
}
