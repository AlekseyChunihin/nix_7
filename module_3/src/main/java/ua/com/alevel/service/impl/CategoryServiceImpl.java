package ua.com.alevel.service.impl;

import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.dao.impl.CategoryDaoImpl;
import ua.com.alevel.entity.Category;
import ua.com.alevel.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAllCategories(String login, String password) {
        return categoryDao.findAllCategories(login, password);
    }
}
