package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.DeliveryStatus;

import java.util.List;

public interface DeliveryStatusService {

    List<DeliveryStatus> retrieveAll();

    void create(DeliveryStatus status);

    void deleteById(int id);
}
