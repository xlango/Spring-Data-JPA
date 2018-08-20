package com.example.springjpatest.dao;

import com.example.springjpatest.entity.Address;
import com.example.springjpatest.entity.User;
import com.example.springjpatest.entity.ViewInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * t_user 操作
 */
public interface UserRepository {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 查询结果
     */
    List<User> findAllByUsername(String username);

    /**
     * 多表联合查询
     * @return
     */
    @Query(value="SELECT new com.example.springjpatest.entity.ViewInfo(u,a) " +
            "FROM com.example.springjpatest.entity.User u, com.example.springjpatest.entity.Address a WHERE a.addressId = u.id")
    List<ViewInfo> findViewInfo();
    List<ViewInfo> findViewInfoByParm(User user);

    ViewInfo findByAddress(Address address);

    public List<User> findObject();

    public List<User> findByif(User user);

}
