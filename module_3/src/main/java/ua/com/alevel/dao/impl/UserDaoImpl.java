package ua.com.alevel.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.connector.HibernateConnector;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

public class UserDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    Session session = null;

    @Override
    public boolean existById(String login, String password, Integer id) {
        User user = null;
        try {
            session = HibernateConnector.getSession(login, password);
            user = session.createQuery("SELECT u FROM User u WHERE id =" + id, User.class).getSingleResult();
            log.info("user have been found successfully");
        } catch (Exception e) {
            log.error("Failed to find user: {} ", e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user != null;
    }

    @Override
    public boolean existByTelephoneNumber(String login, String password, String telephoneNumber) {
        User user = null;
        try {
            session = HibernateConnector.getSession(login, password);
            user = session.createQuery("FROM User u WHERE telephoneNumber = :telephoneNumber" , User.class).setParameter("telephoneNumber", telephoneNumber).getSingleResult();
            log.info("users have been found successfully");
        } catch (Exception e) {
            log.error("Failed to find user: {} ", e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user != null;
    }
}
