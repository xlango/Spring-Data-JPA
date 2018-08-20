package com.example.springjpatest.test;

import com.example.springjpatest.dao.UserRepository;
import com.example.springjpatest.dao.impl.UserRepositoryImpl;
import com.example.springjpatest.entity.User;
import com.example.springjpatest.service.UserService;
import com.example.springjpatest.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter5ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(Chapter5ApplicationTests.class);

    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    public void test1() throws Exception {
        /*final User user = userRepository.save(new User("u1", "p1"));
        log.info("[添加成功] - [{}]",user);
        final List<User> u1 = userRepository.findAllByUsername("u");
        log.info("[条件查询] - [{}]", u1);*/
        /*Pageable pageable = PageRequest.of(1, 2, Sort.by(Sort.Order.desc("id")));
        final Page<User> users = userRepository.findAll(pageable);
        for (User user:users){
            log.info("[{}] : [{}]",user.getUsername(),user.getPassword());
        }
        List<ViewInfo> viewInfos = userRepository.findViewInfo();
        for (ViewInfo v:viewInfos){
            log.info("[{}] : [{}]",v.getUser().getUsername(),v.getAddress().getCity());
        }*/
        //log.info("[分页+排序+查询所有] - [{}]", users.getContent());
        /*userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> log.info("[主键查询] - [{}]", user1));
        final User edit = userRepository.save(new User(user.getId(), "修改后的ui", "修改后的p1"));
        log.info("[修改成功] - [{}]", edit);*/
        /*userRepository.deleteById(user.getId());
        log.info("[删除主键为 {} 成功] - [{}]", user.getId());*/

        User user=new User();
        user.setUsername("u1");
        user.setId(4L);
        Pageable pageable = PageRequest.of(1, 2);
        Page<User> all = userServiceImpl.findAll();
        for (User user1:all){
            log.info("用户名：[{}]，密码：[{}]",user1.getUsername(),user1.getPassword());
        }
    }


}
