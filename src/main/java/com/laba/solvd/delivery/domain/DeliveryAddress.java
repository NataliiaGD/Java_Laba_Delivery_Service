package com.laba.solvd.delivery.domain;

public class DeliveryAddress {
    private int id;
    private String address;
    private int customer_id;

    public DeliveryAddress(int id, String address, int customer_id) {
        this.id = id;
        this.address = address;
        this.customer_id = customer_id;
    }

    public DeliveryAddress() {

    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", customer_id=" + customer_id +
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
