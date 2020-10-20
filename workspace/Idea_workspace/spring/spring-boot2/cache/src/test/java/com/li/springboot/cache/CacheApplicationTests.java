package com.li.springboot.cache;

import com.li.springboot.cache.domain.Employee;
import com.li.springboot.cache.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmpMapper mapper;


    @Test
    public void contextLoads() {
    }

    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void cacheTest(){
        // stringRedisTemplate.opsForValue().append("msg", "hello");
        // System.out.println(stringRedisTemplate.opsForValue().get("msg"));

        // stringRedisTemplate.opsForList().leftPush("l", "1");
        // stringRedisTemplate.opsForList().leftPush("l", "2");
        // stringRedisTemplate.opsForList().leftPush("l", "3");
        //
        // stringRedisTemplate.opsForSet().add("set", "1", "2", "3", "4");

        List<Employee> all = mapper.getAll();
        // stringRedisTemplate.opsForValue().set("all", all);
        redisTemplate.opsForValue().set("all",all);
    }
}
