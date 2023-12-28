package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.OrderHistory;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.OrderHistoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderHistoryRepositoryImpl implements OrderHistoryRepository {
    private static final Logger LOGGER = LogManager.getLogger(OrderHistoryRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public OrderHistory findById(int id) {
        return null;
    }

    @Override
    public List<OrderHistory> retrieveAll() {
        return null;
    }

    @Override
    public void create(OrderHistory orderHistory) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO order_histories (customer_id,order_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, orderHistory.getOrder_id());
            ps.setInt(2, orderHistory.getCustomer_id());
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
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM order_histories WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
