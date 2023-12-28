package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Vehicle;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.VehicleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private static final Logger LOGGER = LogManager.getLogger(VehicleRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Vehicle findById(int id) {
        return null;
    }

    @Override
    public List<Vehicle> retrieveAll() {
        return null;
    }

    @Override
    public void create(Vehicle vehicle) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO vehicles (vehicle_type,company_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, vehicle.getVehicle_type());
            ps.setInt(2, vehicle.getCompany_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateVehicleByVehicleType(int id, String newVehicleType) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM vehicles WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
