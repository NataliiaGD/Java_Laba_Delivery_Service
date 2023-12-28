package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressRepository {
    DeliveryAddress findById(int id);

    List<DeliveryAddress> retrieveAll();

    void create(DeliveryAddress address);

    void updateDeliveryAddressByAddress(int id, String newAddress);

    void deleteById(int id);
}
