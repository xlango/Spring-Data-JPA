#Spring Data JPA
1.实现与概念：常见的ORM框架中Hibernate的JPA最为完整，因此Spring Data JPA 是采用基于JPA规范的Hibernate框架基础下提供了Repository层的实现。Spring Data Repository极大地简化了实现各种持久层的数据库访问而写的样板代码量，同时CrudRepository提供了丰富的CRUD功能去管理实体类。 <br>
2.优点:  <br>
(1)丰富的API，简单操作无需编写额外的代码  <br>
(2)丰富的SQL日志输出  <br>
3.缺点:  <br>
(1)学习成本较大，需要学习HQL <br>
(2)配置复杂，虽然SpringBoot简化的大量的配置，关系映射多表查询配置依旧不容易  <br>
(3)性能较差，对比JdbcTemplate、Mybatis等ORM框架，它的性能无异于是最差的  <br>