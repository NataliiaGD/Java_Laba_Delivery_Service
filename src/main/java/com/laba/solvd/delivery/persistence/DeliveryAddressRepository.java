package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressRepository {

    List<DeliveryAddress> retrieveAll();

    void create(DeliveryAddress address);

    void deleteById(int id);
}
