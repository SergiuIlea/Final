package org.fasttrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private boolean verified;
    private boolean status;
    private Product product;

    public Order(int orderId, boolean verified, boolean status, Product product) {
        this.orderId = orderId;
        this.verified = verified;
        this.status = status;
        this.product = product;
    }

    public Order(boolean verified, boolean status, Product product) {
        this.verified = verified;
        this.status = status;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
