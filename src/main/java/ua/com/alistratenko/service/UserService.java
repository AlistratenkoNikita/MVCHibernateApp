package ua.com.alistratenko.service;

import ua.com.alistratenko.entity.User;

import java.util.List;

public interface UserService {
    void createNewUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByEmail(String email);

    User getUserByLogin(String login);

    User getUserById(String id);
}
