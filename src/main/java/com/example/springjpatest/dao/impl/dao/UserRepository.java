package com.example.springjpatest.dao.impl.dao;

import com.example.springjpatest.entity.User;
import com.example.springjpatest.entity.ViewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * t_user 操作
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
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
}
