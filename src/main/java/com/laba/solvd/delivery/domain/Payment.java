package com.laba.solvd.delivery.domain;

public class Payment {
    private int id;
    private String paymentDetails;
    private int orderId;

    public Payment(int id, String paymentDetails, int orderId) {
        this.id = id;
        this.paymentDetails = paymentDetails;
        this.orderId = orderId;
    }

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payment_details='" + paymentDetails + '\'' +
                ", order_id=" + orderId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
