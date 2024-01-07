package com.laba.solvd.delivery.persistence.impl;

import com.laba.solvd.delivery.domain.Courier;
import com.laba.solvd.delivery.persistence.ConnectionPool;
import com.laba.solvd.delivery.persistence.CourierRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourierRepositoryImpl implements CourierRepository {
    private static final Logger LOGGER = LogManager.getLogger(CourierRepositoryImpl.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public Courier findById(int id) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM couriers where id = ?")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            Courier courier = new Courier();
            while (resultSet.next()) {
                courier.setId(resultSet.getInt("id"));
                courier.setFirstName(resultSet.getString("first_name"));
                courier.setLastName(resultSet.getString("last_name"));
                courier.setCompanyId(resultSet.getInt("company_id"));
            }
            resultSet.close();
            return courier;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public List<Courier> retrieveAll() {
        List<Courier> couriers = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM couriers")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Courier courier = new Courier();
                courier.setId(resultSet.getInt("id"));
                courier.setFirstName(resultSet.getString("first_name"));
                courier.setLastName(resultSet.getString("last_name"));
                courier.setCompanyId(resultSet.getInt("company_id"));
                couriers.add(courier);
            }
            resultSet.close();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return couriers;
    }

    @Override
    public void create(Courier courier) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO couriers (first_name,last_name,company_id) values (?,?,?)"
                , PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, courier.getFirstName());
            ps.setString(2, courier.getLastName());
            ps.setInt(3, courier.getCompanyId());
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
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM couriers WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
