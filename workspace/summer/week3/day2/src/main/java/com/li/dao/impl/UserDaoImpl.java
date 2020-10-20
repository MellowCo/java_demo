package com.li.dao.impl;

import com.li.dao.IUserDao;
import com.li.entity.User;
import com.li.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @ClassName UserDaoImpl
 * @date 2019/7/16 14:13
 */

public class UserDaoImpl implements IUserDao {
    private JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?)";
        jt.update(sql, user.getName(), user.getgender(), user.getAge(), user.getaddress(), user.getQq(), user.getEmail());
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from user";
        return jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User queryUserById(int id) {
        String sql = "select * from user where id = ?";
        return jt.query(sql, new BeanPropertyRowMapper<User>(User.class), id).get(0);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ? ,gender = ? ,age = ? ,address = ? ,qq = ?,email = ? where id = ?";
        jt.update(sql, user.getName(), user.getgender(), user.getAge(), user.getaddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public void delUserById(int id) {
        String sql = "delete from user where id = ?";
        jt.update(sql, id);
    }

    @Override
    public int totalUser() {
        String sql = "select count(1) from user";
        return jt.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> pageUser(int currentPage, int pageSize, Map<String, String[]> map) {

        StringBuilder sql = new StringBuilder();
        sql.append("select * from user where 1 = 1");

        Map<String, Object> pageSql = pageSql(sql, map);
        List<Object> list = (List<Object>)pageSql.get("list");
        StringBuilder newSql = (StringBuilder)pageSql.get("sql");

        newSql.append(" limit ?,?");
        list.add(currentPage);
        list.add(pageSize);

        return jt.query(newSql.toString(), new BeanPropertyRowMapper<User>(User.class), list.toArray());
    }

    @Override
    public int totalUser(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(1) from user where 1 = 1");

        Map<String, Object> pageSql = pageSql(sql, map);

        List<Object> list = (List<Object>)pageSql.get("list");
        StringBuilder newSql = (StringBuilder)pageSql.get("sql");

        return jt.queryForObject(newSql.toString(), Integer.class, list.toArray());
    }

    @Override
    public Map<String,Object> pageSql(StringBuilder sql,Map<String, String[]> map) {
        List<Object> list = new ArrayList<>();

        Set<String> sets = map.keySet();
        for (String set : sets) {
            if (set.equals("currentPage") || set.equals("rows")) {
                continue;
            } else if (map.get(set)[0].equals("") || map.get(set)[0] == null) {
                continue;
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        Map<String, Object> maps = new HashMap<>();
        maps.put("sql",sql);
        maps.put("list",list);

        return maps;
     }

}
