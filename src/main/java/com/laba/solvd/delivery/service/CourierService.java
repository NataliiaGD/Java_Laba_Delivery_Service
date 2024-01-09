package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Courier;

import java.util.List;

public interface CourierService {
    Courier findById(int id);

    List<Courier> retrieveAll();

    void create(Courier courier);

    void deleteById(int id);
}
