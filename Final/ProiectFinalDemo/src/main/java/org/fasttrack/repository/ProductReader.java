package org.fasttrack.repository;

import org.fasttrack.model.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductReader {
    public static List<Product> getAllProducts(String filePath){
        List<Product> allProducts = new ArrayList<>();
        FileReader reader;
        try {
            reader = new FileReader(filePath);
        }catch (FileNotFoundException exception){
            System.out.println("Could not open the file!");
            return new ArrayList<>();
        }
        Scanner fileScanner = new Scanner(reader);

        while (fileScanner.hasNext()){
            String currentLine = fileScanner.nextLine();
            String[] productParts = currentLine.split("\\|");
            String name = productParts[0];
            int weight = Integer.parseInt(productParts[1]);
            String dimensions = productParts[2];
            String colour = productParts[3];
            int price = Integer.parseInt(productParts[4]);
            Product currentProduct = new Product(name, weight, dimensions, colour, price);
            allProducts.add(currentProduct);
        }
        return allProducts;
    }
}
