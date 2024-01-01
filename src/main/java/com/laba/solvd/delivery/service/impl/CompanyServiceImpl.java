package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Company;
import com.laba.solvd.delivery.persistence.CompanyRepository;
import com.laba.solvd.delivery.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company findById(int id) {
        Company company = companyRepository.findById(id);
        return company;
    }

    @Override
    public List<Company> retrieveAll() {
        List<Company> companies = companyRepository.retrieveAll();
        return companies;
    }

    @Override
    public void create(Company company) {
        companyRepository.create(company);
    }

    @Override
    public void updateCompanyByName(int id, String name) {
        companyRepository.updateCompanyByName(id, name);
    }

    @Override
    public void deleteById(int id) {
        companyRepository.deleteById(id);

    }
}
