package com.revature.daos;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utilities.ConnectionUtility;

public class UserDaoImplementation implements UserDao {
    @Override
    public boolean create(User user) {
        String sql = "insert into users (username, password, first_name, last_name, email, role_id) values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getRoleID());

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from users";
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleID(resultSet.getInt("role_id"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getByID(int id) {
        User user = new User();
        String sql = "select * from users where id = " + id;

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setRoleID(resultSet.getInt("role_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        String sql = "update users set username = ?, password = ?, first_name = ?, last_name = ?, email = ?, role_id = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getRoleID());
            preparedStatement.setInt(7, user.getId());

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "delete from users where id = " + user.getId();

        try(Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {

            if(statement.executeUpdate(sql) == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}