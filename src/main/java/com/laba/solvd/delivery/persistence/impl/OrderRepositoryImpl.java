package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Order;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger LOGGER = LogManager.getLogger(OrderRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public List<Order> retrieveAll() {
        return null;
    }

    @Override
    public void create(Order order) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO orders (order_details,customer_id,courier_id) values (?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, order.getOrder_details());
            ps.setInt(2, order.getCustomer_id());
            ps.setInt(3, order.getCourier_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateOrderByOrderDetails(int id, String newOrderDetails) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM orders WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
