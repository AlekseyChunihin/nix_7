package ua.com.alevel.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.connector.HibernateConnector;
import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private static final Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);

    Session session = null;

    @Override
    public void changeAccountBalance(String login, String password, Account account) {
        try {
            session = HibernateConnector.getSession(login, password);
            session.beginTransaction();
            session.merge(account);
            session.getTransaction().commit();
            log.info("account balance with id {} was changed successfully ", account.getId());
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Failed to change balance: {} ", e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Account> findAllAccountsForUser(int id, String login, String password) {
        List<Account> accounts = new ArrayList<>();
        try {
            session = HibernateConnector.getSession(login, password);
            accounts = session.createQuery("SELECT a FROM Account a where user_id = " + id, Account.class).getResultList();
            log.info("accounts have been found successfully");
        } catch (Exception e) {
            log.error("Failed to find all accounts for user: {} ", e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return accounts;
    }
}
