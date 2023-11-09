package org.fasttrack.controller;

import org.fasttrack.model.OrderDB;
import org.fasttrack.model.Product;
import org.fasttrack.service.OrderDBService;
import org.fasttrack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordersDB")
public class OrderDBController {
    private OrderDBService service;

    private ProductService productService;

    @Autowired
    public OrderDBController(OrderDBService service, ProductService productService) {
        this.service = service;
        this.productService=productService;
    }

    @GetMapping
    public List<OrderDB> getAllOrders(){
        return service.getAllOrders();
    }

    @PostMapping
    public OrderDB addOrder(@RequestBody OrderDB orderDB) {
        return service.addOrder(orderDB);
    }

    @PutMapping("{orderDBId}")
    public OrderDB putOrder(@PathVariable int orderDBId, @RequestBody OrderDB orderDB){
        return service.updateOrder(orderDBId, orderDB);
    }

    @DeleteMapping("{orderDBId}")
    public void removeOrder(@PathVariable int orderDBId) {
        service.removeOrder(orderDBId);
    }

    @GetMapping("{orderDBId}/products")
    public List<Product> getAllProductsForOrder(@PathVariable Integer orderDBId){
        return productService.getProductsByOrderId(orderDBId);
    }
}
