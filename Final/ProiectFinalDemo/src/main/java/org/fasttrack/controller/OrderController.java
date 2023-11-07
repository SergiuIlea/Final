package org.fasttrack.controller;

import org.fasttrack.model.Order;
import org.fasttrack.model.Product;
import org.fasttrack.service.OrderService;
import org.fasttrack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    private OrderService service;

    private ProductService productService;

    @Autowired
    public OrderController(OrderService service, ProductService productService) {
        this.service = service;
        this.productService=productService;
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }

    @PutMapping("{orderId}")
    public Order putOrder(@PathVariable int orderId, @RequestBody Order order){
        return service.updateOrder(orderId, order);
    }

    @DeleteMapping("{orderId}")
    public void removeOrder(@PathVariable int oredrId) {
        service.removeOrder(oredrId);
    }

    @GetMapping("{orderId}/products")
    public List<Product> getAllProductsForOrder(@PathVariable Integer orderId){
        return productService.getProductsByOrderId(orderId);
    }
}
