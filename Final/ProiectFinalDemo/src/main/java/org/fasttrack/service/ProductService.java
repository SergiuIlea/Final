package org.fasttrack.service;

import org.fasttrack.model.Product;
import org.fasttrack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }

    public Product updateProduct(int productId, Product product){
        product.setProductId(productId);
        return repository.save(product);
    }

    public void removeProduct(int productId){
        repository.deleteById(productId);
    }
}
