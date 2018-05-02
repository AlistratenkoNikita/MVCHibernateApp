package ua.com.alistratenko.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.entity.User;

import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        List users = query.list();

        return Collections.checkedList(users, User.class);
    }

    @Override
    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where email = :email");
        query.setParameter("email", email);

        return (User) query.uniqueResult();
    }

    @Override
    public User getUserByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where login = :login");
        query.setParameter("login", login);

        return (User) query.uniqueResult();
    }
}
