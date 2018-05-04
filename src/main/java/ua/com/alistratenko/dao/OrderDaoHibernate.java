package ua.com.alistratenko.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.alistratenko.entity.Order;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDaoHibernate implements OrderDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> listOrders() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Order");
        List list = query.list();

        return Collections.checkedList(list, Order.class);
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public Order getOrderByDate(Date date) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Order where order_date = :order_date");
        query.setParameter("order_date", date);

        return (Order) query.uniqueResult();
    }
}
