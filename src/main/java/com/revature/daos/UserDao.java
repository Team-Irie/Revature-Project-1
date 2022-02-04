package com.revature.daos;

import java.util.List;
import com.revature.models.User;

public interface UserDao {
    public boolean create(User user);
    public List<User> readAll();
    public User readByID(User user);
    public boolean update(User user);
    public boolean delete(User user);
}