package com.laba.solvd.delivery.domain;

public class DeliveryCompanyService {
    private int company_id;
    private int customer_id;

    public DeliveryCompanyService(int company_id, int customer_id) {
        this.company_id = company_id;
        this.customer_id = customer_id;
    }

    public DeliveryCompanyService() {

    }

    @Override
    public String toString() {
        return "DeliveryCompanyService{" +
                "company_id=" + company_id +
                ", customer_id=" + customer_id +
                '}';
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
