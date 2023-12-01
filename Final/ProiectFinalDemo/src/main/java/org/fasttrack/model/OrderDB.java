package org.fasttrack.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ordersDB")
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDB_id")
    private int orderDBId;

    @Column(name = "userName")
    private String username;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @OneToMany
    private List<Product> products;

    public OrderDB(int orderDBId, String username, String mail, String phone, List<Product> products) {
        this.orderDBId = orderDBId;
        this.username = username;
        this.mail = mail;
        this.phone = phone;
        this.products = products;
    }

    public OrderDB(String username, String mail, String phone, List<Product> products) {
        this.username = username;
        this.mail = mail;
        this.phone = phone;
        this.products = products;
    }

    public OrderDB() {
    }

    public int getOrderDBId() {
        return orderDBId;
    }

    public void setOrderDBId(int orderId) {
        this.orderDBId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
