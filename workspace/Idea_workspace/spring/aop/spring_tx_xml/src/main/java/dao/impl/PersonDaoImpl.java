package dao.impl;

import dao.IPersonDao;
import entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName PersonDaoImpl
 * @date 2019/7/14 17:20
 */

public class PersonDaoImpl implements IPersonDao {
    private JdbcTemplate tx;

    public void setTx(JdbcTemplate tx) {
        this.tx = tx;
    }

    @Override
    public List<Person> queryAll() {
        return tx.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public List<Person> queryByID(int id) {
        return tx.query("select * from person where id = ?", new BeanPropertyRowMapper<Person>(Person.class), id);
    }

    @Override
    public void updateByID(Person person) {
        tx.update("update person set money =  money + ? where id = ?",person.getMoney(),person.getId());
    }
}
