package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Courier;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.CourierRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CourierRepositoryImpl implements CourierRepository {
    private static final Logger LOGGER = LogManager.getLogger(CourierRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Courier findById(int id) {
        return null;
    }

    @Override
    public List<Courier> retrieveAll() {
        return null;
    }

    @Override
    public void create(Courier courier) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO couriers (first_name,last_name,company_id) values (?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, courier.getFirst_name());
            ps.setString(2, courier.getLast_name());
            ps.setInt(3, courier.getCompany_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateCourierByFirstName(int id, String newFirstName) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM couriers WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
