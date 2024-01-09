package com.laba.solvd.delivery.domain;

public class DeliveryStatus {
    private int id;
    private String actualStatus;
    private int customerId;
    private int courierId;

    public DeliveryStatus(int id, String actualStatus, int customerId, int courierId) {
        this.id = id;
        this.actualStatus = actualStatus;
        this.customerId = customerId;
        this.courierId = courierId;
    }

    public DeliveryStatus() {

    }

    @Override
    public String toString() {
        return "DeliveryStatus{" +
                "id=" + id +
                ", actual_status='" + actualStatus + '\'' +
                ", customer_id=" + customerId +
                ", courier_id=" + courierId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(String actualStatus) {
        this.actualStatus = actualStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }
}
