package com.laba.solvd.delivery.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class DataBaseConfig {
    private static final Logger LOGGER = LogManager.getLogger(DataBaseConfig.class);
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = DataBaseConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

}
