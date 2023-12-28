package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Courier;
import com.laba.solvd.delivery.persistence.CourierRepository;
import com.laba.solvd.delivery.service.CourierService;

import java.util.List;

public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    public CourierServiceImpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }


    @Override
    public Courier findById(int id) {
        return null;
    }

    @Override
    public List<Courier> retrieveAll() {
        return null;
    }

    @Override
    public void create(Courier courier) {
        courierRepository.create(courier);
    }

    @Override
    public void updateCourierByFirstName(int id, String newFirstName) {

    }

    @Override
    public void deleteById(int id) {
        courierRepository.deleteById(id);

    }
}
