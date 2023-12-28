package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.DeliveryAddress;
import com.laba.solvd.delivery.persistence.DeliveryAddressRepository;
import com.laba.solvd.delivery.service.DeliveryAddressService;

import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressServiceImpl(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    @Override
    public DeliveryAddress findById(int id) {
        return null;
    }

    @Override
    public List<DeliveryAddress> retrieveAll() {
        return null;
    }

    @Override
    public void create(DeliveryAddress address) {
        deliveryAddressRepository.create(address);
    }

    @Override
    public void updateDeliveryAddressByAddress(int id, String newAddress) {

    }

    @Override
    public void deleteById(int id) {
        deliveryAddressRepository.deleteById(id);

    }
}
