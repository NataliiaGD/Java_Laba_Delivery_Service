package com.laba.solvd.delivery.domain;

public class Order {
    private int id;
    private String orderDetails;
    private int courierId;
    private int customerId;

    public Order(int id, String orderDetails, int courierId, int customerId) {
        this.id = id;
        this.orderDetails = orderDetails;
        this.courierId = courierId;
        this.customerId = customerId;
    }

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDetails='" + orderDetails + '\'' +
                ", courierId=" + courierId +
                ", customerId=" + customerId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
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
