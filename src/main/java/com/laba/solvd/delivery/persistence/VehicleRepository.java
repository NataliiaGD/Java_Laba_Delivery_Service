package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> retrieveAll();

    void create(Vehicle vehicle);

    void deleteById(int id);
}
