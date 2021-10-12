package ua.com.alevel.service;

import ua.com.alevel.exception.NoSuchUserException;

public interface UserService {

    boolean existById(String login, String password, Integer id) throws NoSuchUserException;

    boolean existByTelephoneNumber(String login, String password, String telephoneNumber) throws NoSuchUserException;
}
