package com.laba.solvd.delivery.domain;

public class Courier {
    private int id;
    private String firstName;
    private String lastName;
    private int companyId;

    public Courier(int id, String firstName, String lastName, int companyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
    }

    public Courier() {

    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", company_id=" + companyId +
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
