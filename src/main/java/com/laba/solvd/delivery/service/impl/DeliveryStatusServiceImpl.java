package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.DeliveryStatus;
import com.laba.solvd.delivery.persistence.DeliveryStatusRepository;
import com.laba.solvd.delivery.service.DeliveryStatusService;

import java.util.List;

public class DeliveryStatusServiceImpl implements DeliveryStatusService {
    private final DeliveryStatusRepository deliveryStatusRepository;

    public DeliveryStatusServiceImpl(DeliveryStatusRepository deliveryStatusRepository) {
        this.deliveryStatusRepository = deliveryStatusRepository;
    }

    @Override
    public List<DeliveryStatus> retrieveAll() {
        List<DeliveryStatus> deliveryStatuses = deliveryStatusRepository.retrieveAll();
        return deliveryStatuses;
    }

    @Override
    public void create(DeliveryStatus status) {
        deliveryStatusRepository.create(status);
    }

    @Override
    public void deleteById(int id) {
        deliveryStatusRepository.deleteById(id);

    }
}
