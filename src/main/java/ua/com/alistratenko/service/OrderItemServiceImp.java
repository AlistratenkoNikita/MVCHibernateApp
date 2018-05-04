package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.dao.OrderItemDao;
import ua.com.alistratenko.entity.OrderItem;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImp implements OrderItemService {

    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public void createNewOrderItem(OrderItem orderItem) {
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
