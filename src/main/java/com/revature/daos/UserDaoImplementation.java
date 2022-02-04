package com.revature.daos;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utilities.Encryption;
import com.revature.utilities.ConnectionUtility;

public class UserDaoImplementation implements UserDao {
    @Override
    public boolean create(User user) {
        String sql = "insert into user (id, username, password, firstName, lastName, email, roleID) values (?, ?, ? ,?, ?. ?, ?)";

        try (Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setInt(7, user.getRoleID());

            if(preparedStatement.executeUpdate() == 1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> readAll() {
        String sql = "select * from user";
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleID(resultSet.getInt("roleID"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User readByID(User user) {
        String sql = "select * from user where id = ?";

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setEmail(resultSet.getString("email"));
            user.setRoleID(resultSet.getInt("roleID"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        String sql = "update user set id = ?, username = ?, password = ?, firstName = ?, lastName = ?, email = ?, roleID = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setInt(7, user.getRoleID());

            if(preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        String sql = "delete from user where id = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "id");

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}