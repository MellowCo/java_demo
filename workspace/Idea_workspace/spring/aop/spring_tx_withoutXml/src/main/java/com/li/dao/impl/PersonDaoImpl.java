package com.li.dao.impl;

import com.li.dao.IPersonDao;
import com.li.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName PersonDaoImpl
 * @date 2019/7/14 17:20
 */

@Repository("personDao")
public class PersonDaoImpl implements IPersonDao {
    @Autowired
    private JdbcTemplate tx;

    @Override
    public List<Person> queryAll() {
        return tx.query("select * from client", new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public List<Person> queryByID(int id) {
        return tx.query("select * from client where id = ?", new BeanPropertyRowMapper<Person>(Person.class), id);
    }

    @Override
    public void updateByID(Person person) {
        tx.update("update client set money =  money + ? where id = ?",person.getMoney(),person.getId());
    }
}
