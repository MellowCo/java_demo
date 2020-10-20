package com.li.mp;

import com.li.mp.domain.MpUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-20 16:35
 */

@SpringBootTest
public class ARTest {

    @Test
    public void testUpdateByID() {
        MpUser user = new MpUser();
        user.setId(1111111L);
        user.setEmail("2222@qq.com");
        user.setAge(22);
        user.insertOrUpdate();
    }

}
