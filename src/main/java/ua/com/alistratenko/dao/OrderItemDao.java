package ua.com.alistratenko.dao;

import ua.com.alistratenko.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {

    void createOrderItem(OrderItem orderItem);

    List<OrderItem> listOrderItems();

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(OrderItem orderItem);
}
