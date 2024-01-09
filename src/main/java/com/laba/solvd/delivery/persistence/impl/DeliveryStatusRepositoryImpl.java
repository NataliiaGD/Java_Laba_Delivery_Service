package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.DeliveryStatus;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.DeliveryStatusRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryStatusRepositoryImpl implements DeliveryStatusRepository {
    private static final Logger LOGGER = LogManager.getLogger(DeliveryStatusRepositoryImpl.class);

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<DeliveryStatus> retrieveAll() {
        List<DeliveryStatus> deliveryStatuses = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM delivery_statuses")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                DeliveryStatus deliveryStatus = new DeliveryStatus();
                deliveryStatus.setId(resultSet.getInt("id"));
                deliveryStatus.setActualStatus(resultSet.getString("actual_status"));
                deliveryStatus.setCustomerId(resultSet.getInt("customer_id"));
                deliveryStatus.setCourierId(resultSet.getInt("courier_id"));
                deliveryStatuses.add(deliveryStatus);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return deliveryStatuses;
    }

    @Override
    public void create(DeliveryStatus status) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO delivery_statuses (actual_status,customer_id,courier_id) values (?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, status.getActualStatus());
            ps.setInt(2, status.getCustomerId());
            ps.setInt(3, status.getCourierId());
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
