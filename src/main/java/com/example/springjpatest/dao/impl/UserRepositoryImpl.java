package com.example.springjpatest.dao.impl;

import com.example.springjpatest.dao.UserRepository;
import com.example.springjpatest.entity.Address;
import com.example.springjpatest.entity.User;
import com.example.springjpatest.entity.ViewInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl{

    @PersistenceContext
    private EntityManager em;

    /**
     * Configure the entity manager to be used.
     *
     * @param em the {@link EntityManager} to set.
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public List<User> findAll() {
        String queryString="select u.username,u.password from com.example.springjpatest.entity.User u";
        Query query=em.createQuery(queryString);
        List list=query.getResultList();
        if (list!=null){
            List<User> userList=new ArrayList<User>();
            for (int i=0;i<list.size();i++){
                Object[] o= (Object[]) list.get(i);
                User user=new User();
                user.setUsername(o[0].toString());
                user.setPassword(o[0].toString());
                userList.add(user);
            }
            return userList;
        }else
            return null;
    }

   /* @Override
    public List<User> findAllByUsername(String username) {
        return null;
    }

    @Override
    public List<ViewInfo> findViewInfo() {
        return null;
    }

    @Override
    public List<ViewInfo> findViewInfoByParm(User user) {
        return null;
    }

    @Override
    public ViewInfo findByAddress(Address address) {
        return null;
    }*/

    @Transactional
    //@Override
    public List<User> findObject() {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery();
        Root<User> root=cq.from(User.class);
        cq.select(root);
        //cq.select(cb.construct(User.class,root.get("id"),root.get("username")));
        //cq.multiselect(root.get("id"),root.get("username"));
        Predicate pre=cb.greaterThan(root.get("id").as(Integer.class),cb.parameter(Integer.class,"id"));
        Predicate pre1=cb.equal(root.get("username").as(String.class),cb.parameter(String.class,"username"));

        cq.where(cb.and(pre,pre1));//or
        cq.orderBy(cb.desc(root.get("id")));//多条件使用逗号分开

        Query query=em.createQuery(cq);
        query.setParameter("id",1);
        query.setParameter("username","u2");
        List<User> users= query.getResultList();
        return users;
    }

    //@Override
    public List<User> findByif(User user) {
        //创建CriteriaBuilder安全查询工厂
        //CriteriaBuilder是一个工厂对象,安全查询的开始.用于构建JPA安全查询.
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        //创建CriteriaQuery安全查询主语句
        //CriteriaQuery对象必须在实体类型或嵌入式类型上的Criteria 查询上起作用。
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        //Root 定义查询的From子句中能出现的类型
        Root<User> itemRoot = query.from(User.class);
        //Predicate 过滤条件 构建where字句可能的各种条件
        //这里用List存放多种查询条件,实现动态查询
        List<Predicate> predicatesList = new ArrayList<>();
        //name模糊查询 ,like语句
        if ( user.getUsername()!= null) {
            predicatesList.add(
                    criteriaBuilder.and(
                            criteriaBuilder.like(
                                    itemRoot.get("username"), "%" + user.getUsername() + "%")));
        }
        // itemPrice 小于等于 <= 语句le,大于等于 >= 语句ge
        if (user.getId() != null) {
            predicatesList.add(
                    criteriaBuilder.and(
                            criteriaBuilder.le(
                                    itemRoot.get("id"), user.getId())));
        }
        if ( user.getPassword()!= null) {
            predicatesList.add(
                    criteriaBuilder.and(
                            criteriaBuilder.like(
                                    itemRoot.get("password"), "%" + user.getPassword() + "%")));
        }
        //where()拼接查询条件
        query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
        TypedQuery<User> typedQuery = em.createQuery(query);
        List<User> resultList = typedQuery.getResultList();
        return resultList;

    }



}
