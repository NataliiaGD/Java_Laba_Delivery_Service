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
    public DeliveryStatus findById(int id) {
        return null;
    }

    @Override
    public List<DeliveryStatus> retrieveAll() {
        return null;
    }

    @Override
    public void create(DeliveryStatus status) {
        deliveryStatusRepository.create(status);
    }

    @Override
    public void updateDeliveryStatusByActualStatus(int id, String newActualStatus) {

    }

    @Override
    public void deleteById(int id) {
        deliveryStatusRepository.deleteById(id);

    }
}
