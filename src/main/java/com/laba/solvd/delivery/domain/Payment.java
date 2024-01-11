package com.laba.solvd.delivery.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.laba.solvd.delivery.parser.JacksonAdapter;
import com.laba.solvd.delivery.parser.MyAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {
    private int id;
    private String paymentDetails;
    private int orderId;
    @XmlJavaTypeAdapter(MyAdapter.class)
    @JsonDeserialize(using = JacksonAdapter.class)
    private LocalDate localDate;

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
                ", paymentDetails='" + paymentDetails + '\'' +
                ", orderId=" + orderId +
                ", localDate=" + localDate +
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
