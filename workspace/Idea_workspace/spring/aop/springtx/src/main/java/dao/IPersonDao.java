package dao;

import entity.Person;

public interface IPersonDao {

    void updatePerson(Person person);

    void queryPersonById(int id);

    void queryPerson();

    void addPerson(Person person);
}
