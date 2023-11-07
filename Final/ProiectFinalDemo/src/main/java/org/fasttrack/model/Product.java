package org.fasttrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Weight(g)")
    private int weight;

    @Column(name = "Dimensions(mm)")
    private String dimensions;

    @Column(name = "Colour")
    private String colour;

    @Column(name = "Price")
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    public Product(String name, int weight, String dimensions, String colour, int price) {
        this.name = name;
        this.weight = weight;
        this.dimensions = dimensions;
        this.colour = colour;
        this.price = price;
    }

    public Product(int productId, String name, int weight, String dimensions, String colour, int price, Order order) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.dimensions = dimensions;
        this.colour = colour;
        this.price = price;
        this.order = order;
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

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
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
