package com.li.mp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.mp.dao.MpUserMapper;
import com.li.mp.domain.MpUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-20 16:35
 */

@SpringBootTest
public class UpdateTest {

    @Autowired
    private MpUserMapper mapper;

    @Test
    public void testUpdateByID() {
        MpUser user = new MpUser();
        user.setId(111111L);
        user.setAge(12);
        user.setEmail("222@qq.com");
        int i = mapper.updateById(user);
        System.out.println("更新行数+" + i);
    }

    @Test
    public void testUpdateByWrapper() {
        UpdateWrapper<MpUser> wrapper = new UpdateWrapper<>();
        //将age小于12并且邮箱不为空的，年龄改为12，邮箱改为
        wrapper.lt("age", 12).isNotNull("email");

        MpUser user = new MpUser();
        user.setAge(12);
        user.setEmail("222@qq.com");

        int i = mapper.update(user, wrapper);
        System.out.println("更新行数+" + i);
    }

    @Test
    public void testUpdateByWrapper2() {
        UpdateWrapper<MpUser> wrapper = new UpdateWrapper<>();
        //将age小于12并且邮箱不为空的，年龄改为12，邮箱改为
        wrapper.lt("age", 12).isNotNull("email")
                .set("age", 12).set("email", "222@qq.com");

        int i = mapper.update(null, wrapper);
        System.out.println("更新行数+" + i);
    }


    @Test
    public void testDelByID() {
        int id = 1222;
        int i = mapper.deleteById(id);
        System.out.println("删除了" + i + "条记录");
    }

    @Test
    public void testdeleteByMap() {
        //删除age=12，name=li
        Map<String, Object> maps = new HashMap<>();
        maps.put("age", 12);
        maps.put("name", "li");

        int i = mapper.deleteByMap(maps);
        System.out.println("删除了" + i + "条记录");
    }

    @Test
    public void testdeleteByIds() {
        int i = mapper.deleteBatchIds(Arrays.asList(12,13,141,42));
        System.out.println("删除了" + i + "条记录");
    }

    @Test
    public void testdeleteByWrapper() {
        UpdateWrapper<MpUser> wrapper = new UpdateWrapper<>();
        wrapper.eq("age", 12).eq("name", "li");

        int i = mapper.delete(wrapper);
        System.out.println("删除了" + i + "条记录");
    }



}
