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
            List<Integer> dimensions = new ArrayList<>();
            String allDimensionsAsString = productParts[2];
            allDimensionsAsString.split("x");
            dimensions.addAll(List.of(Integer.parseInt(allDimensionsAsString)));
            List<String> colours = new ArrayList<>();
            String allColoursAsString = productParts[3];
            colours.addAll(List.of(allColoursAsString.split("~")));
            int price = Integer.parseInt(productParts[4]);
            Product currentProduct = new Product(name, weight, dimensions, colours, price);
            allProducts.add(currentProduct);
        }
        return allProducts;
    }
}
