package com.example.springjpatest.service;

import com.example.springjpatest.entity.User;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    public void add(User user);
    public User update(User user);
    public User addOrUpdate(User user);
    public void delete(User user);
    public User findOne(Integer id);
    public Page<User> findAll();
}
