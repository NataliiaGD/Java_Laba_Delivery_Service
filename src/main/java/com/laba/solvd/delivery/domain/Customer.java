package com.laba.solvd.delivery.domain;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    private List<Order> orders;
    @XmlElementWrapper(name = "deliveryAddresses")
    @XmlElement(name = "deliveryAddress")
    private List<DeliveryAddress> deliveryAddresses;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                ", deliveryAddresses=" + deliveryAddresses +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
