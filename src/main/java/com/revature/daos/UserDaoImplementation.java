package com.revature.daos;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utilities.ConnectionUtility;

public class UserDaoImplementation implements UserDao {
    @Override
    public boolean create(User user) {
        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()){

            String sql = "insert into users values (" + user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getFirstName() + "," + user.getLastName() + user.getEmail() + "," + user.getRoleID() + ")";

            if(statement.executeUpdate(sql) == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "select * from users";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getShort(7));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User readByID(User user) {
        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "select * from users where id = " + user.getId();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getShort(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()){

            String sql = "update users set type = " + user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getFirstName() + "," + user.getLastName() + user.getEmail() + "," + user.getRoleID() + "where id = " + user.getId();

            if(statement.executeUpdate(sql) == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        try(Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {

            String sql = "delete from users where id = " + user.getId();

            if(statement.executeUpdate(sql) == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}