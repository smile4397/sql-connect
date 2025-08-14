package com.example.sql_connect;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "registered", nullable = false, updatable = false)
    private Long registered;
    @Column(name="email_address", nullable = false, length=255, unique=true)
    private String email;
    @Column(name="title", nullable = false, length=5)
    private String title;
    @Column(name="first_name", nullable = false, length=50)
    private String first_name;
    @Column(name="last_name", nullable = false, length=50)
    private String last_name;
    @Column(name="address_line_1", nullable = false, length=255)
    private String address_line_1;
    @Column(name="address_line_2", nullable = true, length=255)
    private String address_line_2;
    @Column(name="city", nullable = false, length=255)
    private String city;
    @Column(name="postcode", nullable = false, length=10)
    private String postcode;
    @Column(name="phone_number", nullable = false, length=20)
    private String phone_number;

    @PrePersist
    protected void onCreate() {
        this.registered = System.currentTimeMillis(); // milliseconds since epoch
    }
    public String getEmail_address() {
        return email;
    }
    public void setEmail_address(String email) {
        this.email = email;
    }
    public void lowerEmail(){
        this.email = this.email.toLowerCase();
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getAddress_line_1() {
        return address_line_1;
    }
    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }
    public String getAddress_line_2() {
        return address_line_2;
    }
    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
