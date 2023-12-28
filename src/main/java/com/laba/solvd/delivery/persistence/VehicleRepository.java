package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle findById(int id);

    List<Vehicle> retrieveAll();

    void create(Vehicle vehicle);

    void updateVehicleByVehicleType(int id, String newVehicleType);

    void deleteById(int id);
}
