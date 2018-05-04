package ua.com.alistratenko.dao;

import ua.com.alistratenko.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderDao {

    void createOrder(Order order);

    List<Order> listOrders();

    void updateOrder(Order order);

    void deleteOrder(Order order);

    Order getOrderByDate(Date date);
}
