package com.learn.springbootrediscaffine;

import com.alibaba.fastjson.parser.ParserConfig;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCaching
@Slf4j
public class SpringBootRedisCaffineApplication  implements CommandLineRunner {

    @Value("${fastjson.whiteList}")
    private String fastjsonWhiteList;

    private final JediRepository jediRepository;

    @Autowired
    public SpringBootRedisCaffineApplication(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisCaffineApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("正在尝试开启FastJson白名单中......");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        ParserConfig.getGlobalInstance().addAccept(fastjsonWhiteList);
        log.info("白名单开启成功，作用的包为: {}",fastjsonWhiteList);
        log.info("开始自动插入基本数据");
        List<Jedi> savedJedis = jediRepository.save(Arrays.asList(new Jedi("luke"), new Jedi("yoda")));
        log.info("插入成功,插入的数据为{}",savedJedis);
    }
}
