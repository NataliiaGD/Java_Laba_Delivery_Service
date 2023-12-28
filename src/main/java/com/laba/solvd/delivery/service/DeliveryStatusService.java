package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.DeliveryStatus;

import java.util.List;

public interface DeliveryStatusService {
    DeliveryStatus findById(int id);

    List<DeliveryStatus> retrieveAll();

    void create(DeliveryStatus status);

    void updateDeliveryStatusByActualStatus(int id, String newActualStatus);

    void deleteById(int id);
}
