package com.laba.solvd.delivery.domain;

public class Order {
    private int id;
    private String orderDetails;
    private int customerId;
    private int courierId;

    public Order(int id, String orderDetails, int customerId, int courierId) {
        this.id = id;
        this.orderDetails = orderDetails;
        this.customerId = customerId;
        this.courierId = courierId;
    }

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_details='" + orderDetails + '\'' +
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
