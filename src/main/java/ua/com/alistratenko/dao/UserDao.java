package ua.com.alistratenko.dao;

import ua.com.alistratenko.entity.User;

import java.util.List;

public interface UserDao {

    void createUser(User user);

    List listUsers();

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByEmail(String email);

    User getUserByLogin(String login);
}
