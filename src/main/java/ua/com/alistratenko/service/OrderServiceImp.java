package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.dao.OrderDao;
import ua.com.alistratenko.entity.Order;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void createNewOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.listOrders();
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }

    @Override
    public Order getOrderByDate(Date date) {
        return orderDao.getOrderByDate(date);
    }
}
