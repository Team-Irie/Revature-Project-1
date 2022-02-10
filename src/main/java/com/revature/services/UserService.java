package com.revature.services;

import java.util.List;
import com.revature.models.User;
import com.revature.daos.UserDaoImplementation;

public class UserService {
    private final UserDaoImplementation userDaoImplementation = new UserDaoImplementation();

    public boolean create(User user) { return userDaoImplementation.create(user); }

    public List<User> getAll() { return userDaoImplementation.getAll(); }

    public User getByID(int id) { return userDaoImplementation.getByID(id); }

    public boolean update(User user) {
        return userDaoImplementation.update(user);
    }

    public boolean deleteByID(int id) { return userDaoImplementation.deleteByID(id); }
}