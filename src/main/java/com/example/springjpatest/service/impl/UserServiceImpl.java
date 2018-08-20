package com.example.springjpatest.service.impl;

import com.example.springjpatest.dao.SpecRepository;
import com.example.springjpatest.dao.UserRepository;
import com.example.springjpatest.entity.User;
import com.example.springjpatest.service.UserService;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private SpecRepository specRepository;


    /*public Page<User> findByifToPage(User user, Pageable pageable) {
        Page<User> bookPage = userRepository.findAll(new Specification<User>(){
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(null!=user.getUsername()&&!"".equals(user.getUsername())){
                    list.add(criteriaBuilder.equal(root.get("username").as(String.class), user.getUsername()));
                }
                if(null!=user.getPassword()&&!"".equals(user.getPassword())){
                    list.add(criteriaBuilder.equal(root.get("password").as(String.class), user.getPassword()));
                }
                if(null!=user.getId()&&!"".equals(user.getId())){
                    list.add(criteriaBuilder.equal(root.get("id").as(Integer.class), user.getId()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        return bookPage;
    }*/

    @Override
    public void add(User user) {

    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User addOrUpdate(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findOne(Integer id) {
        return null;
    }

    @Override
    public Page<User> findAll() {
        Pageable pageable = PageRequest.of(0, 2);
        return (Page<User>) specRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery
                    , CriteriaBuilder criteriaBuilder) {
                List<Predicate> preList = new ArrayList<>();
                Predicate predicate=criteriaBuilder.like(root.get("username").as(String.class),"%u%");
                Predicate predicate1=criteriaBuilder.like(root.get("password").as(String.class),"%1%");
                preList.add(predicate);
                preList.add(predicate1);
                return criteriaQuery.where(preList.toArray(new Predicate[preList.size()])).getRestriction();
            }
        },pageable);
    }
}
