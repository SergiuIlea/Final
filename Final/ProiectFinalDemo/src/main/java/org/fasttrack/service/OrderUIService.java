package org.fasttrack.service;

import org.fasttrack.model.OrderUI;
import org.fasttrack.repository.OrderUIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUIService {

    private OrderUIRepository orderUIRepository;

    @Autowired
    public OrderUIService(OrderUIRepository orderUIRepository) {this.orderUIRepository = orderUIRepository;
    }

    public List<OrderUI> getAllOrdersUI(){
        return orderUIRepository.findAll();
    }
    public OrderUI addOrderUI(OrderUI orderUI){
        return orderUIRepository.save(orderUI);
    }

    public OrderUI updateOrderUI(int orderUIId, OrderUI orderUI){
        orderUI.setOrderUIId(orderUIId);
        return orderUIRepository.save(orderUI);
    }

    public void removeOrderUI(int orderUIId){
        orderUIRepository.deleteById(orderUIId);
    }
}
