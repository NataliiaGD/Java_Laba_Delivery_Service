package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Customer;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final Logger LOGGER = LogManager.getLogger(CustomerRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> retrieveAll() {
        return null;
    }

    @Override
    public void create(Customer customer) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO customers (first_name,last_name) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateCustomerByFirstName(int id, String newFirstName) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM customers WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
