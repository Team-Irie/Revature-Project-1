package com.revature.daos;

import java.sql.*;

import java.util.ArrayList;

import com.revature.models.User;
import com.revature.models.User;
import com.revature.utilities.ConnectionUtility;
import com.revature.utilities.Encryption;

public class UserDaoImplementation implements UserDao {
    @Override
    public boolean create(User user) {
        String sql = "insert into user (balance, user_number, user_id) values (?, ?, ?)";

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, user.getBalance());
            preparedStatement.setInt(2, user.getUserNumber());
            preparedStatement.setInt(3, user.getCustomerId());

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
        List<User> users = new ArrayList<User>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                User user = new User();

                user.setBalance(resultSet.getInt("balance"));
                user.setUserNumber(resultSet.getInt("user_number"));
                user.setCustomerId(resultSet.getInt("user_id"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User readByNumber(User user) {
        String sql = "select * from user where user_number = ?";

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            user.setBalance(resultSet.getInt("balance"));
            user.setUserNumber(resultSet.getInt("user_number"));
            user.setCustomerId(resultSet.getInt("user_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean update(User user) {
        String sql = "update user set balance = ?, user_number = ?, user_id = ? where user_number = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(4, user.getBalance());
            preparedStatement.setInt(5, user.getUserNumber());
            preparedStatement.setInt(6, user.getCustomerId());

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
        String sql = "delete from user where user_number = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "user_number");

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}