package com.revature.daos;

import java.util.List;
import com.revature.models.Person;

public interface PersonDao {
    public boolean create(Person person);
    public List<Person> readAll();
    public Person readByID(Person person);
    public boolean update(Person person);
    public boolean delete(Person person);
}