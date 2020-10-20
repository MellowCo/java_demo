package com.li.car;

import com.alibaba.fastjson.JSON;
import com.li.car.entity.Role;
import com.li.car.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CarApplicationTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void contextLoads() {
        Role role = new Role();
        role.setRoleName("admin");
        roleMapper.insert(role);
    }

    @Test
    void roleUser() {
        Role role = new Role();
        role.setRoleName("user");
        roleMapper.insert(role);
    }


    @Test
    void testJson(){
        String uid = "[\"30d4bee9ee5c04d17cecb83b952e6129\",\"43c5bfd2ea3ca35cb0d8f7fb49d46e08\",\"595f57b4a9a85012fce39a732fb9edba\",\"f8412ac7133cb04e441c0b199ac0a813\"]";
        List<String> strings = JSON.parseArray(uid, String.class);
        System.out.println(strings);


    }

}
