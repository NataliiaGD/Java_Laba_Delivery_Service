package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.DeliveryStatus;

import java.util.List;

public interface DeliveryStatusRepository {

    List<DeliveryStatus> retrieveAll();

    void create(DeliveryStatus status);

    void deleteById(int id);
}
