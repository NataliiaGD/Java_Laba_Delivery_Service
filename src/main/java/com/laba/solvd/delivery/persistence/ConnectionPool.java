package com.laba.solvd.delivery.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final static int INITIAL_POOL_SIZE = 1;
    private final static int MAX_POOL_SIZE = 10;
    private final static int MAX_TIMEOUT = 5;
    private static ConnectionPool instance;
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = new ArrayList<>();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(DataBaseConfig.getUrl(), DataBaseConfig.getUsername(), DataBaseConfig.getPassword());

        }
        return instance;
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static int getInitialPoolSize() {
        return INITIAL_POOL_SIZE;
    }

    public Connection getConnection() {
        if (usedConnections.size() < MAX_POOL_SIZE) {
            try {
                Connection connection = createConnection(url, user, password);
                usedConnections.add(connection);
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException("Error creating a new connection", e);
            }
        }
        throw new RuntimeException("Maximum pool size reached, no available connections!");
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Connection> getConnectionPool() {
        return connectionPool;
    }

    public List<Connection> getUsedConnections() {
        return usedConnections;
    }

    public void shutdown() throws SQLException {
        usedConnections.forEach(this::releaseConnection);
        for (Connection c : connectionPool) {
            c.close();
        }
        connectionPool.clear();
    }
}
