package com.laba.solvd.delivery.domain;

public class DeliveryAddress {
    private int id;
    private String address;
    private int customerId;

    public DeliveryAddress(int id, String address, int customerId) {
        this.id = id;
        this.address = address;
        this.customerId = customerId;
    }

    public DeliveryAddress() {

    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", customer_id=" + customerId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
