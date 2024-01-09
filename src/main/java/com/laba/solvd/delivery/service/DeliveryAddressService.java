package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {

    List<DeliveryAddress> retrieveAll();

    void create(DeliveryAddress address);

    void deleteById(int id);
}
