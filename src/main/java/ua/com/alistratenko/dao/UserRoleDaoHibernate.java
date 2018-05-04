package ua.com.alistratenko.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.alistratenko.entity.UserRole;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRoleDaoHibernate implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createRole(UserRole role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public List<UserRole> listRoles() {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserRole");
        List list = query.list();

        return Collections.checkedList(list, UserRole.class);
    }

    @Override
    public void updateRole(UserRole role) {
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public void deleteRole(UserRole role) {
        sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    public UserRole getRoleByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserRole where name = :name");
        query.setParameter("name", name);

        return (UserRole) query.uniqueResult();
    }

    @Override
    public UserRole getRoleById(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserRole where id = :id");
        query.setParameter("id", Long.valueOf(id));

        return (UserRole) query.uniqueResult();
    }
}
