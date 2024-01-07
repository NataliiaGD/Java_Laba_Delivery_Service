package com.laba.solvd.delivery.domain;

public class Feedback {
    private int id;
    private int rating;
    private String comments;
    private int customerId;
    private int orderId;

    public Feedback(int id, int rating, String comments, int customerId, int orderId) {
        this.id = id;
        this.rating = rating;
        this.comments = comments;
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public Feedback() {

    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
