package ua.com.alevel.databaseConnector;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class DatabaseConnector {

    public static EntityManager getEntityManager() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.createEntityManager();
    }
}