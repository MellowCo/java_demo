package com.li.springboot.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcApplicationTests {
    @Autowired
    DataSource source;

    @Test
    public void contextLoads() {
        System.out.println(source.getClass());

    }



}
