package dao.impl;

import dao.IPersonDao;
import entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


public class PersonDoaImpl extends JdbcDaoSupport implements IPersonDao {

    @Override
    public void updatePerson(Person person) {
        getJdbcTemplate().update("update person set name = ?,age = ? where id = ?", person.getName(), person.getAge(), person.getId());
    }

    @Override
    public void queryPersonById(int id) {
        List<Person> query = getJdbcTemplate().query("select * from person where id = ?", new BeanPropertyRowMapper<Person>(Person.class), id);
        System.out.println(query);
    }

    @Override
    public void queryPerson() {
        List<Person> query = getJdbcTemplate().query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        System.out.println(query);
    }

    @Override
    public void addPerson(Person person) {
        getJdbcTemplate().update("insert into person values (?,?,?)", person.getId(), person.getName(), person.getAge());
    }
}
