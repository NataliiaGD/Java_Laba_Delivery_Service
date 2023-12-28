package com.laba.solvd.delivery.domain;

public class Vehicle {
    private int id;
    private String vehicle_type;
    private int company_id;

    public Vehicle(int id, String vehicle_type, int company_id) {
        this.id = id;
        this.vehicle_type = vehicle_type;
        this.company_id = company_id;
    }

    public Vehicle() {

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicle_type='" + vehicle_type + '\'' +
                ", company_id=" + company_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
