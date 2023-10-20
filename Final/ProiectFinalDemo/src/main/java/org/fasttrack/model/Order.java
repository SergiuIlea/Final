package org.fasttrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id")
    private int orderId;

    @Column(name = "Verified")
    private boolean verified;

    @Column(name = "Status")
    private boolean status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "belongingOrder")
    private List<Product> products;

    public Order(int orderId, boolean verified, boolean status, List<Product> products) {
        this.orderId = orderId;
        this.verified = verified;
        this.status = status;
        this.products = products;
    }

    public Order(boolean verified, boolean status, List<Product> products) {
        this.verified = verified;
        this.status = status;
        this.products = products;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        this.products.add(product);
    }
}
