package com.laba.solvd.delivery.domain;

public class OrderHistory {
    private int id;
    private int customerId;
    private int orderId;

    public OrderHistory(int id, int customerId, int orderId) {
        this.id = id;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public OrderHistory() {

    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", customer_id=" + customerId +
                ", order_id=" + orderId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
