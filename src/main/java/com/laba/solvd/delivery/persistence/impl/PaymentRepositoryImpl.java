package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Payment;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.PaymentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {
    private static final Logger LOGGER = LogManager.getLogger(PaymentRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Payment findById(int id) {
        return null;
    }

    @Override
    public List<Payment> retrieveAll() {
        return null;
    }

    @Override
    public void create(Payment payment) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO payments (payment_details,order_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, payment.getPayment_details());
            ps.setInt(2, payment.getOrder_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updatePaymentByPaymentDetails(int id, String newPaymentDetails) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM payments WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
