package com.li.springboot.security;

import com.li.springboot.security.damain.User;
import com.li.springboot.security.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {

    @Autowired
    UserMapper mapper;


    @Test
    public void contextLoads() {
        User li = mapper.queryByName("li");
        // System.out.println(li);
    }

}
