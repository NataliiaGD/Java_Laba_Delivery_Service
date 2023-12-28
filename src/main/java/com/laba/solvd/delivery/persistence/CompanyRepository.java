package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Company;

import java.util.List;

public interface CompanyRepository {
    Company findById(int id);

    List<Company> retrieveAll();

    void create(Company company);

    void updateCompanyByName(int id, String newName);

    void deleteById(int id);

}
