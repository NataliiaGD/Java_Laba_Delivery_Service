package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Order;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger LOGGER = LogManager.getLogger(OrderRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Order> retrieveAll() {
        List<Order> orders = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM orders")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setOrderDetails(resultSet.getString("order_details"));
                order.setCustomerId(resultSet.getInt("customer_id"));
                order.setCourierId(resultSet.getInt("courier_id"));
                orders.add(order);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return orders;
    }

    @Override
    public void create(Order order) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO orders (order_details,customer_id,courier_id) values (?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, order.getOrderDetails());
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getCourierId());
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
