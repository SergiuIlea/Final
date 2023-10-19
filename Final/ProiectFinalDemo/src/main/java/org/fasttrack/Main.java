package org.fasttrack;


import org.fasttrack.model.Product;
import org.fasttrack.repository.ProductReader;
import org.fasttrack.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {
    @Value("${file.location}")
    private String fileLocation;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ProductRepository repository){
        return args -> {
            List<Product> productsFromFile = ProductReader.getAllProducts(fileLocation);
            repository.saveAll(productsFromFile);
        };
    }
}
