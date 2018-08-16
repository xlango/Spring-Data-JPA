package com.example.springjpatest.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    /**
     * TODO 忽略该字段的映射
     */
    @Transient
    private String  email;

    public User() {
    }
    public User(String u1, String p1) {
        this.username=u1;
        this.password=p1;
    }
    public User(Long id, String ui, String p1) {
        this.id=id;
        this.username=ui;
        this.password=p1;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}