package com.laba.solvd.delivery;

import com.laba.solvd.delivery.domain.Company;
import com.laba.solvd.delivery.domain.Courier;
import com.laba.solvd.delivery.persistence.CompanyRepository;
import com.laba.solvd.delivery.persistence.CourierRepository;
import com.laba.solvd.delivery.persistence.impl.mybatis.PersistenceConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Program {


    private static final Logger LOGGER = LogManager.getLogger(Program.class);

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) {
//        CompanyRepository companyRepository = new CompanyRepositoryImpl();
//        CompanyService companyService = new CompanyServiceImpl(companyRepository);
//        Company company = companyService.findById(2);
//        CourierRepository courierRepository = new CourierRepositoryImpl();
//        CourierService courierService = new CourierServiceImpl(courierRepository);
//        LOGGER.info(company);
//
//        List<Company> companies = companyService.retrieveAll();
//
//        Company myCompany = new Company();
//        myCompany.setName("Delivery_company5");
//        companyService.create(myCompany);
//
//        companyService.updateCompanyByName(8, "Delivery_Company4");
//        companyService.deleteById(9);
//        Courier courier = new Courier();
//        courier.setFirst_name("Tomas");
//        courier.setLast_name("Parker");
//        courier.setCompany_id(1);
//        courierService.create(courier);
//
//        companies = companyService.retrieveAll();
//
//        LOGGER.info(companies);


        //MyBatis Implementation

        SqlSession sqlSession = PersistenceConfig.openSession();

        CompanyRepository companyRepository = sqlSession.getMapper(CompanyRepository.class);

        Company company = companyRepository.findById(1);
        LOGGER.info(company);

        List<Company> companies = companyRepository.retrieveAll();
        LOGGER.info(companies);

        CourierRepository courierRepository = sqlSession.getMapper(CourierRepository.class);
        List<Courier> couriers = courierRepository.retrieveAll();
        LOGGER.info(couriers);

    }
}
