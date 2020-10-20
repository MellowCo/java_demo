package dao;

import entity.Person;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName IPersonDao
 * @date 2019/7/14 17:20
 */

public interface IPersonDao {
    List<Person> queryAll();

    List<Person> queryByID(int id);

    void updateByID(Person person);
}
