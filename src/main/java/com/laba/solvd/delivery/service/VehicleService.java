package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> retrieveAll();

    void create(Vehicle vehicle);

    void deleteById(int id);
}
