package ua.com.alevel.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnector {

    private static final Logger log = LoggerFactory.getLogger(JdbcConnector.class);

    public static Connection getConnection(String login, String password) {
        Properties props = loadProperties();
        String url = props.getProperty("url");
        log.info("Connecting to {}", url);
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            log.error("Failed to connect to database {}", e.getMessage());
        }
        return null;
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = JdbcConnector.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException | NullPointerException e) {
            log.error("Failed to get properties {}", e.getMessage());
        }
        return props;
    }
}
