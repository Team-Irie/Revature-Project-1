package com.revature.daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.revature.models.User;
import com.revature.types.UserRole;
import com.revature.utilities.LogUtility;
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
            preparedStatement.setInt(6, user.getRoleID().ordinal());

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e){
            LogUtility.logger.error("UserDaoImplementation.create failed");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from users";
        UserRole[] user_roles = UserRole.values();
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
                user.setRoleID(user_roles[resultSet.getInt("role_id")]);

                users.add(user);
            }

        } catch (SQLException e) {
            LogUtility.logger.error("UserDaoImplementation.getAll failed");
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getByID(int id) {
        String sql = "select * from users where id = ?";
        UserRole[] user_roles = UserRole.values();

        try (Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                User user = new User();

                user.setId(id);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleID(user_roles[resultSet.getInt("role_id")]);

                return user;
            }
        } catch (SQLException e){
            LogUtility.logger.error("UserDaoImplementation.getByID failed");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        String sql = "select * from users where email = ? and password = ?";

        try(Connection connection = ConnectionUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                User user = new User();

                int roleId = resultSet.getInt("role_id");
                UserRole[] userRoles = UserRole.values();

                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleID(userRoles[roleId]);

                return user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
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
            preparedStatement.setInt(6, user.getRoleID().ordinal());
            preparedStatement.setInt(7, user.getId());

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            LogUtility.logger.error("UserDaoImplementation.update failed");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteByID(int id) {
        String sql = "delete from users where id = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            LogUtility.logger.error("UserDaoImplementation.deleteByID failed");
            e.printStackTrace();
        }

        return false;
    }
}