package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.dao.UserDao;
import ua.com.alistratenko.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void createNewUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.listUsers();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }
}
