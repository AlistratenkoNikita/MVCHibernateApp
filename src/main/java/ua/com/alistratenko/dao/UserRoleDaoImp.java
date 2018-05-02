package ua.com.alistratenko.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.alistratenko.entity.UserRole;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRoleDaoImp implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserRole> allRoles() {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserRole");
        List list = query.list();

        return Collections.checkedList(list, UserRole.class);
    }
}
