package com.laba.solvd.delivery.domain;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    private int id;
    private String name;
    @XmlElementWrapper(name = "couriers")
    @XmlElement(name = "courier")
    private List<Courier> couriers;

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company() {

    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", couriers=" + couriers +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
