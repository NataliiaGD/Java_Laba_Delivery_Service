package com.laba.solvd.delivery.domain;

public class Payment {
    private int id;
    private String payment_details;
    private int order_id;

    public Payment(int id, String payment_details, int order_id) {
        this.id = id;
        this.payment_details = payment_details;
        this.order_id = order_id;
    }

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payment_details='" + payment_details + '\'' +
                ", order_id=" + order_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(String payment_details) {
        this.payment_details = payment_details;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
