package org.fasttrack;


import org.fasttrack.model.Order;
import org.fasttrack.model.Product;
import org.fasttrack.repository.OrderRepository;
import org.fasttrack.repository.ProductReader;
import org.fasttrack.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ProductRepository productRepository,
                                OrderRepository orderRepository){
        return args -> {
            List<Product> productsFromFile = ProductReader.getAllProducts("C:\\Users\\gabor\\cursJava\\Final\\ProiectFinalDemo\\src\\main\\resources\\products.txt");
            productRepository.saveAll(productsFromFile);

            List<Product> l1 = new ArrayList<>();
            l1.add(productRepository.getReferenceById(1));
            l1.add(productRepository.getReferenceById(2));
            l1.add(productRepository.getReferenceById(3));

            Order o1 = new Order(false, false, l1);

            productRepository.getReferenceById(1).setBelongingOrder(o1);
            productRepository.getReferenceById(2).setBelongingOrder(o1);
            productRepository.getReferenceById(3).setBelongingOrder(o1);

            productRepository.saveAll(productsFromFile);
            orderRepository.save(o1);

        };
    }
}
