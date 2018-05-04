package ua.com.alistratenko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.alistratenko.entity.OrderItem;

import java.util.List;

@Repository
public class OrderItemDaoHibernate implements OrderItemDao {

    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public void createOrderItem(OrderItem orderItem) {
        orderItemDao.createOrderItem(orderItem);
    }

    @Override
    public List<OrderItem> listOrderItems() {
        return orderItemDao.listOrderItems();
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemDao.updateOrderItem(orderItem);
    }

    @Override
    public void deleteOrderItem(OrderItem orderItem) {
        orderItemDao.deleteOrderItem(orderItem);
    }
}
