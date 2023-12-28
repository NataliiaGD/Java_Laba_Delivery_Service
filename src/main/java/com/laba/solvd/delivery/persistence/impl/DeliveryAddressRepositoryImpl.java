package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.DeliveryAddress;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.DeliveryAddressRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeliveryAddressRepositoryImpl implements DeliveryAddressRepository {
    private static final Logger LOGGER = LogManager.getLogger(DeliveryAddressRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public DeliveryAddress findById(int id) {
        return null;
    }

    @Override
    public List<DeliveryAddress> retrieveAll() {
        return null;
    }

    @Override
    public void create(DeliveryAddress address) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO delivery_addresses (address,customer_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, address.getAddress());
            ps.setInt(2, address.getCustomer_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateDeliveryAddressByAddress(int id, String newAddress) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM delivery_addresses WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
