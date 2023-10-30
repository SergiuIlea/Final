package org.fasttrack.service;

import org.aspectj.weaver.ast.Or;
import org.fasttrack.model.Order;
import org.fasttrack.model.Product;
import org.fasttrack.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(int orderId, Order order){
        order.setOrderId(orderId);
        return orderRepository.save(order);
    }

    public void removeOrder(int orderId){
        orderRepository.deleteById(orderId);
    }
}
