package ua.com.alevel.dao;

import ua.com.alevel.entity.Operation;

import java.util.ArrayList;

public interface OperationDao {

    void addOperation(Operation operation, String login, String password);

    ArrayList<String[]> findOperations(String login, String password, int period, String timeInterval);
}
