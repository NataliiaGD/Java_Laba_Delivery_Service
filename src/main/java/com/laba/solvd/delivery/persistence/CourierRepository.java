package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Courier;

import java.util.List;

public interface CourierRepository {
    Courier findById(int id);

    List<Courier> retrieveAll();

    void create(Courier courier);

    void deleteById(int id);
}
