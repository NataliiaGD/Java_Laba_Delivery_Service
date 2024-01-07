package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Discount;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.DiscountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountRepositoryImpl implements DiscountRepository {
    private static final Logger LOGGER = LogManager.getLogger(DiscountRepositoryImpl.class);

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Discount> retrieveAll() {
        List<Discount> discounts = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM discounts")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Discount discount = new Discount();
                discount.setId(resultSet.getInt("id"));
                discount.setDiscountAmount(resultSet.getInt("discount_amount"));
                discount.setOrderId(resultSet.getInt("order_id"));
                discounts.add(discount);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return discounts;
    }

    @Override
    public void create(Discount discount) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO discounts (discount_amount,order_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, discount.getDiscountAmount());
            ps.setInt(2, discount.getOrderId());
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
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM discounts WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
