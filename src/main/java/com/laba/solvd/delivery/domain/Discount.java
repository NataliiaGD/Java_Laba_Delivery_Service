package com.laba.solvd.delivery.domain;

public class Discount {
    private int id;
    private int discountAmount;
    private int orderId;

    public Discount(int id, int discountAmount, int orderId) {
        this.id = id;
        this.discountAmount = discountAmount;
        this.orderId = orderId;
    }

    public Discount() {

    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discount_amount=" + discountAmount +
                ", order_id=" + orderId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
