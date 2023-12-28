package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Discount;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.DiscountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DiscountRepositoryImpl implements DiscountRepository {
    private static final Logger LOGGER = LogManager.getLogger(DiscountRepositoryImpl.class);

    private ConnectionPool connectionPool = ConnectionPool.create("jdbc:mysql://127.0.0.1:3306/delivery_service",
            "root", "Qwerty123");

    @Override
    public Discount findById(int id) {
        return null;
    }

    @Override
    public List<Discount> retrieveAll() {
        return null;
    }

    @Override
    public void create(Discount discount) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO discounts (discount_amount,order_id) values (?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, discount.getDiscount_amount());
            ps.setInt(2, discount.getOrder_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void updateDiscountByDiscountAmount(int id, String newDiscountAmount) {

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
