package org.fasttrack.service;

import org.fasttrack.model.Product;
import org.fasttrack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(int productId, Product product){
        product.setProductId(productId);
        return productRepository.save(product);
    }

    public void removeProduct(int productId){
        productRepository.deleteById(productId);
    }
}
