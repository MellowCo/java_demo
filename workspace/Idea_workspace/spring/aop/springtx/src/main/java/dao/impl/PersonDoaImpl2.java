package dao.impl;

import dao.IPersonDao;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDao")
public class PersonDoaImpl2 implements IPersonDao {
    
    @Autowired
    JdbcTemplate jt = null;

    @Override
    public void updatePerson(Person person) {
        jt.update("update person set name = ?,age = ? where id = ?", person.getName(), person.getAge(), person.getId());
    }

    @Override
    public void queryPersonById(int id) {
        List<Person> query = jt.query("select * from person where id = ?", new BeanPropertyRowMapper<Person>(Person.class), id);
        System.out.println(query);
    }

    @Override
    public void queryPerson() {
        List<Person> query = jt.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        System.out.println(query);
    }

    @Override
    public void addPerson(Person person) {
        jt.update("insert into person values (?,?,?)", person.getId(), person.getName(), person.getAge());
    }
}
