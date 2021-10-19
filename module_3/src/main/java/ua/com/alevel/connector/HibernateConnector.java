package ua.com.alevel.connector;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

    private static Configuration configuration = new Configuration().configure();

    public static Session getSession(String login, String password) {
        configuration = new Configuration().configure();
        configuration.setProperty("hibernate.connection.username", login);
        configuration.setProperty("hibernate.connection.password", password);
        Session session = configuration.buildSessionFactory().openSession();
        return session;
    }
}
