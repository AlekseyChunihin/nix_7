package ua.com.alevel.service;

import ua.com.alevel.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccountsForUser(int id, String login, String password);
}
