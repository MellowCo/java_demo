package com.li.mp;

import com.li.mp.service.impl.MpUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-20 16:35
 */

@SpringBootTest
public class ServiceTest {

    @Autowired
    private MpUserServiceImpl service;

    @Test
    public void testUpdateByID() {

    }

}
