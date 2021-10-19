package ua.com.alevel.connector;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

    public static Session getSession(String login, String password) {
        Configuration configuration = new Configuration().configure();
        configuration.setProperty("hibernate.connection.username", login);
        configuration.setProperty("hibernate.connection.password", password);
        return configuration.buildSessionFactory().openSession();
    }
}
