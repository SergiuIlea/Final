package org.fasttrack.controller;

import org.fasttrack.model.OrderUI;
import org.fasttrack.service.OrderUIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordersUI")
public class OrderUIController {
    private OrderUIService service;


    @Autowired
    public OrderUIController(OrderUIService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderUI> getAllOrdersUI(){
        return service.getAllOrdersUI();
    }

    @PostMapping
    public OrderUI addOrderUI(@RequestBody OrderUI orderUI) {
        return service.addOrderUI(orderUI);
    }

    @PutMapping("{orderUIId}")
    public OrderUI putOrderUI(@PathVariable int orderUIId, @RequestBody OrderUI orderUI){
        return service.updateOrderUI(orderUIId, orderUI);
    }

    @DeleteMapping("{orderUIId}")
    public void removeOrderUI(@PathVariable int orderUIId) {
        service.removeOrderUI(orderUIId);
    }

}
