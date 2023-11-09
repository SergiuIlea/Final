package org.fasttrack;


import org.fasttrack.model.OrderDB;
import org.fasttrack.model.Product;
import org.fasttrack.repository.OrderDBRepository;
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
                                OrderDBRepository orderDBRepository){
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

            List<Product> l2 = new ArrayList<>();
            l2.add(babyYodaBlack);
            l2.add(vase3DBlack);
            l2.add(worldCup);

            OrderDB o1 = new OrderDB("Sergiu", "sergiu.ilea09@gmail.com", "0748842879", l1);
            orderDBRepository.save(o1);

            babyYodaMarble.setOrderDB(o1);
            babyGrootWavingBlack.setOrderDB(o1);
            vaseHeartShape.setOrderDB(o1);

            productRepository.save(babyYodaMarble);
            productRepository.save(babyGrootWavingBlack);
            productRepository.save(vaseHeartShape);

            OrderDB o2 = new OrderDB("Andrei", "andrei.ilea@gmail.com", "0740492267", l2);
            orderDBRepository.save(o2);

            babyYodaBlack.setOrderDB(o2);
            vase3DBlack.setOrderDB(o2);
            worldCup.setOrderDB(o2);

            productRepository.save(babyYodaBlack);
            productRepository.save(vase3DBlack);
            productRepository.save(worldCup);

        };
    }
}
