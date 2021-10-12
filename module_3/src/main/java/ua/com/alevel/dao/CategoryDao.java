package ua.com.alevel.dao;

import ua.com.alevel.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAllCategories(String login, String password);
}
