package ua.com.alevel.dao;

import ua.com.alevel.entity.Operation;

import java.sql.ResultSet;

public interface OperationDao {

    void addOperation(Operation operation, String login, String password);

    ResultSet findOperations(String login, String password, int period, String timeInterval);
}
