package com.laba.solvd.delivery.domain;

public class Discount {
    private int id;
    private int discount_amount;
    private int order_id;

    public Discount(int id, int discount_amount, int order_id) {
        this.id = id;
        this.discount_amount = discount_amount;
        this.order_id = order_id;
    }

    public Discount() {

    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discount_amount=" + discount_amount +
                ", order_id=" + order_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(int discount_amount) {
        this.discount_amount = discount_amount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
