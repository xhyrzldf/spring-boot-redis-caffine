package com.learn.springbootrediscaffine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * spring-boot-redis-caffine.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @date : 2018/3/28 22:37
 */
@RestController
@RequestMapping("/jedis")
public class JediController {

    private final JediRepository jediRepository;

    @Autowired
    public JediController(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    @Cacheable(cacheNames = "redis", key = "'jediList'")
    @GetMapping
    public List<Jedi> jedis() {
        return jediRepository.findAll();
    }

    @Cacheable(cacheNames = "redis", key = "'jedi'+#id")
    @GetMapping("/{id}")
    public Jedi jediById(@PathVariable("id") Integer id) {
        return jediRepository.findOne(id);
    }

    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "redis", key = "'jediList'"),
                    @CacheEvict(cacheNames = "redis", key = "'jedi1'")
            }
    )
    @DeleteMapping("/caches")
    public ResponseEntity removeCache() {
        jediRepository.deleteAll();
        return ResponseEntity.ok("缓存以及数据删除成功");
    }

}
