package org.fasttrack.controller;

import org.fasttrack.model.Product;
import org.fasttrack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("{productId}")
    public Product putProduct(@PathVariable int productId, @RequestBody Product product){
        return service.updateProduct(productId, product);
    }

    @DeleteMapping("{productId}")
    public void removeProduct(@PathVariable int productId){
        service.removeProduct(productId);
    }

}
