package org.fasttrack.service;

import org.fasttrack.model.OrderDB;
import org.fasttrack.repository.OrderDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDBService {
    private OrderDBRepository orderDBRepository;

    @Autowired
    public OrderDBService(OrderDBRepository orderDBRepository) {this.orderDBRepository = orderDBRepository;
    }

    public List<OrderDB> getAllOrders(){
        return orderDBRepository.findAll();
    }
    public OrderDB addOrder(OrderDB orderDB){
        return orderDBRepository.save(orderDB);
    }

    public OrderDB updateOrder(int orderDBId, OrderDB orderDB){
        orderDB.setOrderDBId(orderDBId);
        return orderDBRepository.save(orderDB);
    }

    public void removeOrder(int orderDBId){
        orderDBRepository.deleteById(orderDBId);
    }
}
