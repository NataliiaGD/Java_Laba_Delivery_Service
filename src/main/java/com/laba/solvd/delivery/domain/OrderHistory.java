package com.laba.solvd.delivery.domain;

public class OrderHistory {
    private int id;
    private int customer_id;
    private int order_id;

    public OrderHistory(int id, int customer_id, int order_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.order_id = order_id;
    }

    public OrderHistory() {

    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", order_id=" + order_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
