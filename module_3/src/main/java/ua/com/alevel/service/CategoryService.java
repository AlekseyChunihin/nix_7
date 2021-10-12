package ua.com.alevel.service;

import ua.com.alevel.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories(String login, String password);
}
