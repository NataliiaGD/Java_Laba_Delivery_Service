package com.laba.solvd.delivery.domain;

public class Vehicle {
    private int id;
    private String vehicleType;
    private int companyId;

    public Vehicle(int id, String vehicleType, int companyId) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.companyId = companyId;
    }

    public Vehicle() {

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicle_type='" + vehicleType + '\'' +
                ", company_id=" + companyId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
