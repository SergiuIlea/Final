package org.fasttrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "user")
    private String user;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @OneToMany
    private List<Product> products;

    public Order(int orderId, String user, String mail, String phone, List<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.mail = mail;
        this.phone = phone;
        this.products = products;
    }

    public Order(String user, String mail, String phone, List<Product> products) {
        this.user = user;
        this.mail = mail;
        this.phone = phone;
        this.products = products;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
