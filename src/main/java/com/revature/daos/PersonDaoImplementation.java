package com.revature.daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.utilities.Encryption;
import com.revature.utilities.ConnectionUtility;

public class PersonDaoImplementation implements PersonDao {
    @Override
    public boolean create(Person person) {
        String sql = "insert into person (type, first_name, last_name, email, password) values (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, person.getType().ordinal());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, Encryption.hashString(person.getPassword()));

            if(preparedStatement.executeUpdate() == 1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Person> readAll() {
        String sql = "select * from person";
        List<Person> people = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                Person person = new Person();

                Type[] types = Type.values();

                person.setId(resultSet.getInt("id"));
                person.setType(types[resultSet.getInt("type")]);
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public Person readByID(Person person) {
        String sql = "select * from person where id = ?";

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Type[] types = Type.values();

            person.setId(resultSet.getInt("id"));
            person.setType(types[resultSet.getInt("type")]);
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public boolean update(Person person) {
        String sql = "update person set type = ?, first_name = ?, last_name = ?, email = ?, password = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, person.getType().ordinal());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, Encryption.hashString(person.getPassword()));
            preparedStatement.setInt(6, person.getId());

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Person person) {
        String sql = "delete from person where id = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "id");

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}