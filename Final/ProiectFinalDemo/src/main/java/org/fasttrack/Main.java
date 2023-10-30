package org.fasttrack;


import jakarta.persistence.criteria.CriteriaBuilder;
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
import java.util.Optional;

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

            List<Product> allProductsFromDB = productRepository.findAll();

            Product babyYodaMarble = allProductsFromDB.get(0);
            Product babyWhite = allProductsFromDB.get(1);
            Product babyYodaBlack = allProductsFromDB.get(2);
            Product babyGrootWavingWood = allProductsFromDB.get(3);
            Product babyGrootWavingWhite = allProductsFromDB.get(4);
            Product babyGrootWavingBlack = allProductsFromDB.get(5);
            Product babyGrootWonderingWood = allProductsFromDB.get(6);
            Product babyGrootWonderingWhite = allProductsFromDB.get(7);
            Product babyGrootWonderingBlack = allProductsFromDB.get(8);
            Product vase3DWhite = allProductsFromDB.get(9);
            Product vase3DBlack = allProductsFromDB.get(10);
            Product vase2Pieces = allProductsFromDB.get(11);
            Product vaseHeartShape = allProductsFromDB.get(12);
            Product lighterCaseUClujWhite = allProductsFromDB.get(13);
            Product lighterCaseUClujBlack = allProductsFromDB.get(14);
            Product worldCup = allProductsFromDB.get(15);

            List<Product> l1 = new ArrayList<>();
            l1.add(babyYodaMarble);
            l1.add(babyGrootWavingBlack);
            l1.add(vaseHeartShape);

           /*List<Product> l1 = new ArrayList<>();
            l1.add(productRepository.getReferenceById(1));
            l1.add(productRepository.getReferenceById(2));
            l1.add(productRepository.getReferenceById(3));*/

            Order o1 = new Order("Sergiu", "sergiu.ilea09@gmail.com", "0748842879", l1);
            orderRepository.save(o1);

        };
    }
}
