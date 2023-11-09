package org.fasttrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ordersUI")
public class OrderUI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderUI_id")
    private int orderUIId;

    @Column(name = "userName")
    private String username;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "products")
    private String products;

    public OrderUI(int orderUIId, String username, String mail, String phone, String products) {
        this.orderUIId = orderUIId;
        this.username = username;
        this.mail = mail;
        this.phone = phone;
        this.products = products;
    }

    public OrderUI(String username, String mail, String phone, String products) {
        this.username = username;
        this.mail = mail;
        this.phone = phone;
        this.products = products;
    }

    public OrderUI() {
    }

    public int getOrderUIId() {
        return orderUIId;
    }

    public void setOrderUIId(int orderUIId) {
        this.orderUIId = orderUIId;
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

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
