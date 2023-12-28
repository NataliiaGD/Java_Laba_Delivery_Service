package com.laba.solvd.delivery.domain;

public class Order {
    private int id;
    private String order_details;
    private int customer_id;
    private int courier_id;

    public Order(int id, String order_details, int customer_id, int courier_id) {
        this.id = id;
        this.order_details = order_details;
        this.customer_id = customer_id;
        this.courier_id = courier_id;
    }

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_details='" + order_details + '\'' +
                ", customer_id=" + customer_id +
                ", courier_id=" + courier_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_details() {
        return order_details;
    }

    public void setOrder_details(String order_details) {
        this.order_details = order_details;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }
}
