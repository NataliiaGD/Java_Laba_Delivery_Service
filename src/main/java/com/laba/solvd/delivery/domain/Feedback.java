package com.laba.solvd.delivery.domain;

public class Feedback {
    private int id;
    private int rating;
    private String comments;
    private int customer_id;
    private int order_id;

    public Feedback(int id, int rating, String comments, int customer_id, int order_id) {
        this.id = id;
        this.rating = rating;
        this.comments = comments;
        this.customer_id = customer_id;
        this.order_id = order_id;
    }

    public Feedback() {

    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
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
