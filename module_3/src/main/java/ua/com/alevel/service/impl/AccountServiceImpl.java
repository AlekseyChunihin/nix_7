package ua.com.alevel.service.impl;

import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.dao.impl.AccountDaoImpl;
import ua.com.alevel.entity.Account;
import ua.com.alevel.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public List<Account> findAllAccountsForUser(int id, String login, String password) {
        return accountDao.findAllAccountsForUser(id, login, password);
    }
}
