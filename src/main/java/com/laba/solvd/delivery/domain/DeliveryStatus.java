package com.laba.solvd.delivery.domain;

public class DeliveryStatus {
    private int id;
    private String actual_status;
    private int customer_id;
    private int courier_id;

    public DeliveryStatus(int id, String actual_status, int customer_id, int courier_id) {
        this.id = id;
        this.actual_status = actual_status;
        this.customer_id = customer_id;
        this.courier_id = courier_id;
    }

    public DeliveryStatus() {

    }

    @Override
    public String toString() {
        return "DeliveryStatus{" +
                "id=" + id +
                ", actual_status='" + actual_status + '\'' +
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

    public String getActual_status() {
        return actual_status;
    }

    public void setActual_status(String actual_status) {
        this.actual_status = actual_status;
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
