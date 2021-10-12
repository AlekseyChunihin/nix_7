package ua.com.alevel.dao;

import ua.com.alevel.entity.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAllAccountsForUser(int id, String login, String password);

    public void changeAccountBalance(String login, String password, Account account);
}
