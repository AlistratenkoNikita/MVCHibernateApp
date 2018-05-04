package ua.com.alistratenko.service;

import ua.com.alistratenko.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    void createNewOrder(Order order);

    List<Order> getAllOrders();

    void updateOrder(Order order);

    void deleteOrder(Order order);

    Order getOrderByDate(Date date);
}
