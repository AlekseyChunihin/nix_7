package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.exception.NoSuchUserException;
import ua.com.alevel.service.UserService;

public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean existById(String login, String password, Integer id) throws NoSuchUserException {
        boolean isUserExists = userDao.existById(login, password, id);
        if (!isUserExists) {
            log.error("Failed to find user");
            throw new NoSuchUserException();
        }
        return isUserExists;
    }

    @Override
    public boolean existByTelephoneNumber(String login, String password, String telephoneNumber) throws NoSuchUserException {
        boolean isUserExists = userDao.existByTelephoneNumber(login, password, telephoneNumber);
        if (!isUserExists) {
            log.error("Failed to find user");
            throw new NoSuchUserException();
        }
        return isUserExists;
    }
}
