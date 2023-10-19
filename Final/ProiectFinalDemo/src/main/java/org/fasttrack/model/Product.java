package org.fasttrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    private String name;
    private int weight;
    private List<Integer> dimensions;
    private List<String> colour;
    private int price;
    private Order order;

    public Product(int productId, String name, int weight, List<Integer> dimensions, List<String> colour, int price, Order order) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.dimensions = dimensions;
        this.colour = colour;
        this.price = price;
        this.order = order;
    }

    public Product(String name, int weight, List<Integer> dimensions, List<String> colour, int price, Order order) {
        this.name = name;
        this.weight = weight;
        this.dimensions = dimensions;
        this.colour = colour;
        this.price = price;
        this.order = order;
    }

    public Product(String name, int weight, List<Integer> dimensions, List<String> colour, int price) {
        this.name = name;
        this.weight = weight;
        this.dimensions = dimensions;
        this.colour = colour;
        this.price = price;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Integer> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<Integer> dimensions) {
        this.dimensions = dimensions;
    }

    public List<String> getColour() {
        return colour;
    }

    public void setColour(List<String> colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
