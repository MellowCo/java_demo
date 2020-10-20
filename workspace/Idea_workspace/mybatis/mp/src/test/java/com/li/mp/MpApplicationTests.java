package com.li.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.mp.dao.MpUserMapper;
import com.li.mp.domain.MpUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private MpUserMapper mapper;

    @Test
    public void testMp() {
        MpUser user = new MpUser();
        user.setAge(122);
        user.setCreateTime(System.currentTimeMillis());
        user.setEmail("xxxx234@163.com");
        user.setId(11114L);
        user.setName("li23");
        user.setManagerId(2222224L);
        mapper.insert(user);
    }
    @Test
    public void testlist() {

        List<MpUser> mpUsers = mapper.selectList(null);
        for (MpUser mpUser : mpUsers) {
            System.out.println(mpUser);
        }
    }

    @Test
    public void selectById() {
        MpUser user = mapper.selectById(11114);
        System.out.println(user);
    }

    @Test
    public void selectByIds() {
        List<Long> ids = Arrays.asList(11114L, 11111111111111L, 111111111111112L);
        List<MpUser> mpUsers = mapper.selectBatchIds(ids);
        mpUsers.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "li");
        map.put("age", 12);
        // map.put("managerId",222222222222222L);

        List<MpUser> mpUsers = mapper.selectByMap(map);
        mpUsers.forEach(System.out::println);
    }

    //名字中包含雨并且年龄小于40
    @Test
    public void selectByWrapper() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.lt("age",40).like("name","雨");
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //名字中包含雨并且年龄在20到40之间并且email不为空
    @Test
    public void selectByWrapper2() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.like("name","雨").between("age",20,40).isNotNull("email");
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //名字姓王或者年龄大于等于25，按照年龄降序，年龄相同按照id升序
    @Test
    public void selectByWrapper3() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.likeRight("name", "王").or().ge("age", 25)
                .orderByDesc("age")
                .orderByAsc("id");
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //创建日期为2019年2月14日并且上级为名字姓王的
    @Test
    public void selectByWrapper4() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        //map.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-02-14").inSql("manager_id", "select id from mp_user where name like '王%'").var;
        map.apply("date_format(create_time,'%Y-%m-%d')='2019-02-14'" ).inSql("manager_id", "select id from mp_user where name like '王%'");
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //名字姓王并且（年龄小于40或邮箱不为空）
    //name like '王%' and (age < 40 or email isNotNull)
    @Test
    public void selectByWrapper5() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.likeRight("name", "王").and(i -> i.lt("age", 40).or().isNotNull("email"));
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //名字姓王或者（年龄小于40并且邮箱不为空）
    //name like '王%' or (age < 40 and email isNotNull)
    @Test
    public void selectByWrapper6() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.likeRight("name", "王").or(i -> i.lt("age", 40).isNotNull("email"));
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //（年龄小于40或邮箱不为空）并且 名字姓王
    //(age < 40 or email isNotNull) and name like '王%'
    @Test
    public void selectByWrapper7() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.nested(i->i.lt("age",40).or().isNotNull("email")).likeRight("name", "王");
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //年龄等于(12,23,13,43)
    //age in (12,23,13,43)
    @Test
    public void selectByWrapper8() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.in("age", Arrays.asList(12, 23, 13, 43));
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //名字中包含雨并且年龄小于40
    //select id,name where name like '%雨%' and age < 40
    @Test
    public void selectByWrapperSupper() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.lt("age",40).like("name","雨").select("id","name");
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    //名字中包含雨并且年龄小于40
    //select id,name,age,email where name like '%雨%' and age < 40
    @Test
    public void selectByWrapperSupper2() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.lt("age",40).like("name","雨")
                .select(MpUser.class,i->!i.getColumn().equals("create_time")
                &&!i.getColumn().equals("manager_id"));
        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperSupper3() {
        String name = "wang";
        String email = "";
        condition(name,email);
    }

    public void condition(String name,String email){
        QueryWrapper<MpUser> map = new QueryWrapper<>();

        // if (!StringUtils.isEmpty(name)){
        //     map.like("name", name);
        // }
        //
        // if (!StringUtils.isEmpty(email)){
        //     map.like("email", email);
        // }
        map.like(!StringUtils.isEmpty(name), "name", name)
                .like(!StringUtils.isEmpty(email), "email", email);

        List<MpUser> mpUsers = mapper.selectList(map);
    }

    //创建条件构造器时传入实体对象
    @Test
    public void selectByWrapperSupper5() {
        MpUser user = new MpUser();
        user.setName("li");
        user.setAge(12);

        // QueryWrapper<MpUser> map = new QueryWrapper<>(user);
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.like("name", "li").eq("age", 12);

        List<MpUser> mpUsers = mapper.selectList(map);
        mpUsers.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperByMap() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.like("name", "li").eq("age", 12).select("id","name");
        List<Map<String, Object>> maps = mapper.selectMaps(map);
        maps.forEach(System.out::println);
    }

    //按照上级分组，查询每组的平均年龄，最大年龄，最小年龄，并且只取年龄总和小于500的组
    //select avg(age) avg_age,max(age) max_age,min(age) min_age from mp_user group by manager_id having sum(age) < 500
    @Test
    public void selectByWrapperByMap2() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.select("avg(age) avg_age", "max(age) max_age", "min(age) min_age")
                .groupBy("manager_id")
                .having("sum(age)<{0}", 500);
        List<Map<String, Object>> maps = mapper.selectMaps(map);
        maps.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperObjs() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.select("avg(age) avg_age", "max(age) max_age", "min(age) min_age")
                .groupBy("manager_id")
                .having("sum(age)<{0}", 500);
        List<Object> maps = mapper.selectObjs(map);
        maps.forEach(System.out::println);
    }
    @Test
    public void selectByWrapperCount() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.lt("age", 50);
        Integer count = mapper.selectCount(map);
        System.out.println(count);
    }

    @Test
    public void selectByWrapperOne() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.lt("age", 1000);
        MpUser count = mapper.selectOne(map);
        System.out.println(count);
    }

    @Test
    public void selectByWrapperMy() {
        QueryWrapper<MpUser> map = new QueryWrapper<>();
        map.lt("age", 1000);
        List<MpUser> mpUsers = mapper.selectAll(map);
        System.out.println(mpUsers);
    }

    @Test
    public void selectByWrapperPage() {
        Page<MpUser> page = new Page<>(1,2,false);
        IPage<MpUser> userPage = mapper.selectPage(page, null);

        System.out.println("总数据：" + userPage.getTotal());
        System.out.println("总页数：" + userPage.getPages());
        //分页数据
        List<MpUser> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperMap() {
        Page<Map<String, Object>> page = new Page<>(1,2);
        Page<Map<String, Object>> mapPage = mapper.selectMapsPage(page, null);

        System.out.println("总数据：" + mapPage.getTotal());
        System.out.println("总页数：" + mapPage.getPages());
        //分页数据
        List<Map<String, Object>> records = mapPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void myPage() {
        Page<MpUser> page = new Page<>(1,2,false);
        IPage<MpUser> userPage = mapper.myPage(page,new QueryWrapper<>());

        System.out.println("总数据：" + userPage.getTotal());
        System.out.println("总页数：" + userPage.getPages());
        //分页数据
        List<MpUser> records = userPage.getRecords();
        records.forEach(System.out::println);
    }


}
