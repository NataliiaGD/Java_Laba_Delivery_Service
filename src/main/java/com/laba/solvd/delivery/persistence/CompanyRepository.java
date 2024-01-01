package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyRepository {
    Company findById(int id);

    List<Company> retrieveAll();

    void create(Company company);

    void updateCompanyByName(@Param("id") int id, @Param("name") String name);

    void deleteById(int id);

}
