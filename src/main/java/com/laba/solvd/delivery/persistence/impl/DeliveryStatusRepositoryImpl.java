package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.DeliveryStatus;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.DeliveryStatusRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeliveryStatusRepositoryImpl implements DeliveryStatusRepository {
    private static final Logger LOGGER = LogManager.getLogger(DeliveryStatusRepositoryImpl.class);

    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public DeliveryStatus findById(int id) {
        return null;
    }

    @Override
    public List<DeliveryStatus> retrieveAll() {
        return null;
    }

    @Override
    public void create(DeliveryStatus status) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO delivery_statuses (actual_status,customer_id,courier_id) values (?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, status.getActual_status());
            ps.setInt(2, status.getCustomer_id());
            ps.setInt(3, status.getCourier_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateDeliveryStatusByActualStatus(int id, String newActualStatus) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM delivery_statuses WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
