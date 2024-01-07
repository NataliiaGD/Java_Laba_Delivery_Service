package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Feedback;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.FeedbackRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepositoryImpl implements FeedbackRepository {
    private static final Logger LOGGER = LogManager.getLogger(FeedbackRepositoryImpl.class);

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Feedback> retrieveAll() {
        List<Feedback> feedbacks = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM feedbacks")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(resultSet.getInt("id"));
                feedback.setRating(resultSet.getInt("rating"));
                feedback.setComments(resultSet.getString("comments"));
                feedback.setCustomerId(resultSet.getInt("customer_id"));
                feedback.setOrderId(resultSet.getInt("order_id"));
                feedbacks.add(feedback);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return feedbacks;
    }

    @Override
    public void create(Feedback feedback) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO feedbacks (rating,comments,customer_id,order_id) values (?,?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, feedback.getRating());
            ps.setString(2, feedback.getComments());
            ps.setInt(3, feedback.getCustomerId());
            ps.setInt(4, feedback.getOrderId());
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
