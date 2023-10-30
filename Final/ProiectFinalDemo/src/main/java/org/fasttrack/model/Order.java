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
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;

    public Order(int orderId, String userName, String mail, String phoneNumber, List<Product> products) {
        this.orderId = orderId;
        this.userName = userName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

    public Order(String userName, String mail, String phoneNumber, List<Product> products) {
        this.userName = userName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }
}
