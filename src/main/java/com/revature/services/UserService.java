package com.revature.services;

import java.util.List;
import com.revature.models.User;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImplementation;

public class UserService {
    private final UserDao userDao = new UserDaoImplementation();

    public boolean create(User user) { return userDao.create(user); }

    public List<User> getAll() { return userDao.getAll(); }

    public User getByID(User user) { return userDao.getByID(user.getId()); }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean delete(User user) {
        return userDao.delete(user);
    }
}