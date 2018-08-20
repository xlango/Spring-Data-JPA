package com.example.springjpatest.dao;

import com.example.springjpatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SpecRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

    /*public void add(User user);
    public User update(User user);
    public User addOrUpdate(User user);
    public void delete(User user);
    public User findOne(Integer id);
    public List<User> findAll();*/
}
