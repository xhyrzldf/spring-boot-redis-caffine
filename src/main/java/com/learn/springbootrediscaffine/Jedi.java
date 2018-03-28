package com.learn.springbootrediscaffine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Description : spring-boot-redis-caffeine.
 * Date : 2018/3/28 22:31
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Jedi implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    public Jedi(String name) {
        this.name = name;
    }
}
