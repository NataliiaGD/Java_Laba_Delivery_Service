package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.OrderHistory;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.OrderHistoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryRepositoryImpl implements OrderHistoryRepository {
    private static final Logger LOGGER = LogManager.getLogger(OrderHistoryRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<OrderHistory> retrieveAll() {
        List<OrderHistory> orderHistories = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM order_histories")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setId(resultSet.getInt("id"));
                orderHistory.setCustomerId(resultSet.getInt("customer_id"));
                orderHistory.setOrderId(resultSet.getInt("order_id"));
                orderHistories.add(orderHistory);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return orderHistories;
    }

    @Override
    public void create(OrderHistory orderHistory) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO order_histories (customer_id,order_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, orderHistory.getOrderId());
            ps.setInt(2, orderHistory.getCustomerId());
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
