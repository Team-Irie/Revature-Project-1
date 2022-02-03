package com.revature.services;

import java.util.List;
import com.revature.models.Person;
import com.revature.daos.PersonDao;
import com.revature.daos.PersonDaoImplementation;

public class PersonService {
        private final PersonDao personDao = new PersonDaoImplementation();

        public boolean create(Person person) { return personDao.create(person); }

        public List<Person> readAll() { return personDao.readAll(); }

        public Person readByID(Person person) { return personDao.readByID(person); }

        public boolean update(Person person) {
                return personDao.update(person);
        }

        public boolean delete(Person person) {
                return personDao.delete(person);
        }
}