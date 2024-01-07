package com.laba.solvd.delivery.domain;

public class DeliveryCompanyService {
    private int companyId;
    private int customerId;

    public DeliveryCompanyService(int companyId, int customerId) {
        this.companyId = companyId;
        this.customerId = customerId;
    }

    public DeliveryCompanyService() {

    }

    @Override
    public String toString() {
        return "DeliveryCompanyService{" +
                "company_id=" + companyId +
                ", customer_id=" + customerId +
                '}';
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
