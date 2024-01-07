package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Company;
import com.laba.solvd.delivery.persistence.CompanyRepository;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepositoryImpl implements CompanyRepository {
    private static final Logger LOGGER = LogManager.getLogger(CompanyRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public Company findById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM companies where id = ?")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            Company company = new Company();
            while (resultSet.next()) {
                company.setId(resultSet.getInt("id"));
                company.setName(resultSet.getString("name"));
            }
            resultSet.close();
            return company;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public List<Company> retrieveAll() {
        List<Company> companies = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM companies")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = new Company();
                company.setId(resultSet.getInt("id"));
                company.setName(resultSet.getString("name"));
                companies.add(company);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return companies;
    }

    @Override
    public void create(Company company) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO companies (name) values (?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, company.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }


    }

    @Override
    public void updateCompanyByName(int id, String name) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("Update companies set name = ? where id = ? ")) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM companies WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
