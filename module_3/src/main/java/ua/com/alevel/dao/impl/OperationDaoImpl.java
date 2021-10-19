package ua.com.alevel.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.connector.HibernateConnector;
import ua.com.alevel.connector.JdbcConnector;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.entity.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

public class OperationDaoImpl implements OperationDao {

    private static final Logger log = LoggerFactory.getLogger(OperationDaoImpl.class);

    private Session session = null;

    @Override
    public void addOperation(Operation operation, String login, String password) {
        try {
            session = HibernateConnector.getSession(login, password);
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
    public ArrayList<String[]> findOperations(String login, String password, int period, String timeInterval) {
        ArrayList<String[]> operations = new ArrayList<>();
        String[] header = "id,time,sum,category_id,account_id".split(",");
        operations.add(header);
        String getAccountStatementForPeriodSqlQuery = "";
        switch (timeInterval) {
            case "1": {
                getAccountStatementForPeriodSqlQuery = "SELECT * FROM  operations WHERE  time >= DATEADD(MINUTE,-?, getdate()) and  time <= getdate()";
            }
            break;
            case "2": {
                getAccountStatementForPeriodSqlQuery = "SELECT * FROM  operations WHERE  time >= DATEADD(HOUR,-?, getdate()) and  time <= getdate()";
            }
            break;
            case "3": {
                getAccountStatementForPeriodSqlQuery = "SELECT * FROM  operations WHERE  time >= DATEADD(DAY,-?, getdate()) and  time <= getdate()";
            }
            break;
            case "4": {
                getAccountStatementForPeriodSqlQuery = "SELECT * FROM  operations WHERE  time >= DATEADD(MONTH,-?, getdate()) and  time <= getdate()";
            }
            break;
            default:
                System.out.println("Incorrect input");
        }
        Connection connection = JdbcConnector.getConnection(login, password);
        try (PreparedStatement preparedStatement = connection.prepareStatement(getAccountStatementForPeriodSqlQuery)) {
            preparedStatement.setInt(1, period);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String accountStatementEntry = resultSet.getLong("id") +
                        "," +
                        resultSet.getTimestamp("time") +
                        "," +
                        resultSet.getInt("sum") +
                        "," +
                        resultSet.getInt("category_id") +
                        "," +
                        resultSet.getInt("account_id");
                String[] arr = accountStatementEntry.split(",");
                operations.add(arr);
            }
            resultSet.close();
        } catch (SQLException e) {
            log.error("could not find operations {} ", e.getMessage());
        }
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("could not close connection {} ", e.getMessage());
        }
        return operations;
    }
}
