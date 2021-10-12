package ua.com.alevel.dao;

public interface UserDao {

    boolean existById(String login, String password, Integer id);

    boolean existByTelephoneNumber(String login, String password, String telephoneNumber);
}
