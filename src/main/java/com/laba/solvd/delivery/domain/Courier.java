package com.laba.solvd.delivery.domain;

public class Courier {
    private int id;
    private String first_name;
    private String last_name;
    private int company_id;

    public Courier(int id, String first_name, String last_name, int company_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_id = company_id;
    }

    public Courier() {

    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", company_id=" + company_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
