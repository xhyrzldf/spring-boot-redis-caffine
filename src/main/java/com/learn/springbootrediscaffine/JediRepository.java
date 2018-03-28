package com.learn.springbootrediscaffine;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring-boot-redis-caffine.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @date : 2018/3/29 0:29
 */
public interface JediRepository extends JpaRepository<Jedi,Integer> {
}
