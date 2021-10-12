package ua.com.alevel.service;

import ua.com.alevel.entity.Operation;

public interface OperationService {

    void addOperation(Operation operation, String login, String password);

    void createAccountStatementFile(String login, String password, int period, String timeInterval);
}
