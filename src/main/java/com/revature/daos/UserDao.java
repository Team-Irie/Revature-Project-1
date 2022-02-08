package com.revature.daos;

import java.util.List;
import com.revature.models.User;

public interface UserDao {
    public boolean create(User user);
    public List<User> getAll();
    public User getByID(int id);
    public boolean update(User user);
    public boolean delete(User user);
}