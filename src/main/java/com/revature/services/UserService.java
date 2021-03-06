package com.revature.services;

import java.util.List;
import com.revature.models.User;
import com.revature.daos.UserDao;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public boolean create(User user) { return userDao.create(user); }

    public List<User> getAll() { return userDao.getAll(); }

    public User getByID(int id) { return userDao.getByID(id); }

    public User getByEmailAndPassword(String email, String password) { return userDao.getByEmailAndPassword(email, password); }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean deleteByID(int id) { return userDao.deleteByID(id); }
}