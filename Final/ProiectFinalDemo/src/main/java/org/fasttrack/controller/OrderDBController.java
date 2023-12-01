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
    public List<OrderDB> getAllOrdersDB(){

        return service.getAllOrdersDB();
    }

    @PostMapping
    public OrderDB addOrderDB(@RequestBody OrderDB orderDB) {
        return service.addOrderDB(orderDB);
    }

    @PutMapping("{orderDBId}")
    public OrderDB putOrderDB(@PathVariable int orderDBId, @RequestBody OrderDB orderDB){
        return service.updateOrderDB(orderDBId, orderDB);
    }

    @DeleteMapping("{orderDBId}")
    public void removeOrderDB(@PathVariable int orderDBId) {
        service.removeOrderDB(orderDBId);
    }

    @GetMapping("{orderDBId}/products")
    public List<Product> getAllProductsForOrderDB(@PathVariable Integer orderDBId){
        return productService.getProductsByOrderId(orderDBId);
    }
}
