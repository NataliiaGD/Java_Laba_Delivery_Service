package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Company;

import java.util.List;

public interface CompanyService {
    Company findById(int id);

    List<Company> retrieveAll();

    void create(Company company);

    void updateCompanyByName(int id, String name);

    void deleteById(int id);
}
