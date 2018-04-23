package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alistratenko.dao.UserDao;
import ua.com.alistratenko.entity.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        List<User> users;

        users = userDao.listUsers();

        return users;
    }
}
