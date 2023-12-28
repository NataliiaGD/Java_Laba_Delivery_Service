package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Feedback;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.FeedbackRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FeedbackRepositoryImpl implements FeedbackRepository {
    private static final Logger LOGGER = LogManager.getLogger(FeedbackRepositoryImpl.class);

    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Feedback findById(int id) {
        return null;
    }

    @Override
    public List<Feedback> retrieveAll() {
        return null;
    }

    @Override
    public void create(Feedback feedback) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO feedbacks (rating,comments,customer_id,order_id) values (?,?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, feedback.getRating());
            ps.setString(2, feedback.getComments());
            ps.setInt(3, feedback.getCustomer_id());
            ps.setInt(4, feedback.getOrder_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateFeedbackByComments(int id, String newComments) {

    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM feedbacks WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
