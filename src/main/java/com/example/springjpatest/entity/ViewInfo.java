package com.example.springjpatest.entity;

import java.io.Serializable;

public class ViewInfo implements Serializable {
    private User user;
    private Address address;

    public ViewInfo() {
    }

    public ViewInfo(User user, Address address) {
        this.user = user;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
