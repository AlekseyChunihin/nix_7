package ua.com.alevel.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.connector.HibernateConnector;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);

    private Session session = null;

    @Override
    public List<Category> findAllCategories(String login, String password) {
        List<Category> categories = new ArrayList<>();
        try {
            session = HibernateConnector.getSession(login, password);
            categories = session.createQuery("SELECT c FROM Category c", Category.class).getResultList();
            log.info("categories have been found successfully");

        } catch (Exception e) {
            log.error("Failed to find all categories: {} ", e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return categories;
    }
}
