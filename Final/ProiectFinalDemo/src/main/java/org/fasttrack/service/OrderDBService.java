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

    public List<OrderDB> getAllOrdersDB(){
        return orderDBRepository.findAll();
    }
    public OrderDB addOrderDB(OrderDB orderDB){
        return orderDBRepository.save(orderDB);
    }

    public OrderDB updateOrderDB(int orderDBId, OrderDB orderDB){
        orderDB.setOrderDBId(orderDBId);
        return orderDBRepository.save(orderDB);
    }

    public void removeOrderDB(int orderDBId){
        orderDBRepository.deleteById(orderDBId);
    }
}
