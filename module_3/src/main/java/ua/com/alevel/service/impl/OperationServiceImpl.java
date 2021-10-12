package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.dao.impl.AccountDaoImpl;
import ua.com.alevel.dao.impl.OperationDaoImpl;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.exception.InvalidCategoryForTheOperationTypeException;
import ua.com.alevel.exception.OperationWithZeroTurnoverException;
import ua.com.alevel.service.OperationService;
import ua.com.alevel.util.ConvertResultSetToCsvUtil;

public class OperationServiceImpl implements OperationService {

    private static final Logger log = LoggerFactory.getLogger(OperationService.class);

    OperationDao operationDao = new OperationDaoImpl();
    AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void addOperation(Operation operation, String login, String password) {
        try {
            if (doesTheTransactionAmountMatchTheCategoryType(operation)) {
                Account account = operation.getAccount();
                account.setBalance(account.getBalance() + operation.getSum());
                accountDao.changeAccountBalance(login, password, account);
                operationDao.addOperation(operation, login, password);
                log.info("Operation added successfully");
            }
        } catch (OperationWithZeroTurnoverException | InvalidCategoryForTheOperationTypeException e) {
            log.error("Adding operation failed {}", e.getMessage());
        }
    }

    private boolean doesTheTransactionAmountMatchTheCategoryType(Operation operation) throws OperationWithZeroTurnoverException, InvalidCategoryForTheOperationTypeException {
        if ((operation.getSum() > 0 && operation.getCategory().getCategory_type()) ||
                (operation.getSum() < 0 && !operation.getCategory().getCategory_type())) {
            return true;
        } else if (operation.getSum() == 0) {
            throw new OperationWithZeroTurnoverException(operation.getSum());
        } else if ((operation.getSum() > 0 && !operation.getCategory().getCategory_type()) ||
                (operation.getSum() < 0 && operation.getCategory().getCategory_type())) {
            throw new InvalidCategoryForTheOperationTypeException();
        }
        return false;
    }

    @Override
    public void createAccountStatementFile(String login, String password, int period, String timeInterval) {
        ConvertResultSetToCsvUtil.createCSVFileWithAccountStatement(operationDao.findOperations(login, password, period, timeInterval));
    }
}
