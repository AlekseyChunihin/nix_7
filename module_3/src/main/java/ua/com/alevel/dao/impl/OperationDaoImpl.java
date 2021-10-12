package ua.com.alevel.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.connector.HibernateConnector;
import ua.com.alevel.connector.JdbcConnector;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.entity.Operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;

public class OperationDaoImpl implements OperationDao {

    private static final Logger log = LoggerFactory.getLogger(OperationDaoImpl.class);

    Session session = null;
    Connection connection = null;

    @Override
    public void addOperation(Operation operation, String login, String password) {
        try {
            session = HibernateConnector.getSessionFactory(login, password).openSession();
            session.beginTransaction();
            Instant instant = Instant.now();
            operation.setTime(instant);
            session.persist(operation);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("failed to add operation: {}" + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ResultSet findOperations(String login, String password, int period, String timeInterval) {
        connection = JdbcConnector.getConnection(login, password);
        switch (timeInterval) {
            case "1": {
                String sqlQueryInMinutes = "SELECT * FROM  operations WHERE  time >= DATEADD(MINUTE,-" + period + ", getdate()) and  time <= getdate()";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sqlQueryInMinutes);
                    return result;
                } catch (SQLException e) {
                    log.error("could not find operations {} ", e.getMessage());
                }
            }
            break;
            case "2": {
                String sqlQueryInHours = "SELECT * FROM  operations WHERE  time >= DATEADD(HOUR,-" + period + ", getdate()) and  time <= getdate()";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sqlQueryInHours);
                    return result;
                } catch (SQLException e) {
                    log.error("could not find operations {} ", e.getMessage());
                }
            }
            break;
            case "3": {
                String sqlQueryInDays = "SELECT * FROM  operations WHERE  time >= DATEADD(DAY,-" + period + ", getdate()) and  time <= getdate()";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sqlQueryInDays);
                    return result;
                } catch (SQLException e) {
                    log.error("could not find operations {} ", e.getMessage());
                }
            }
            break;
            case "4": {
                String sqlQueryInMonths = "SELECT * FROM  operations WHERE  time >= DATEADD(MONTH,-" + period + ", getdate()) and  time <= getdate()";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sqlQueryInMonths);
                    return result;
                } catch (SQLException e) {
                    log.error("could not find operations {} ", e.getMessage());
                }
            }
            break;
            default:
                System.out.println("Incorrect input");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            log.info("failed to close {}", e.getMessage());
        }
        return null;
    }
}
