package ua.com.alistratenko.service;

import ua.com.alistratenko.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    void createNewOrderItem(OrderItem orderItem);

    List<OrderItem> listOrderItems();

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(OrderItem orderItem);
}
