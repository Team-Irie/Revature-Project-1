package com.revature.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Person;
import com.revature.utilities.ConnectionUtility;
import com.revature.utilities.Encryption;

public class AccountDaoImplementation implements AccountDao {
    @Override
    public boolean create(Account account) {
        String sql = "insert into account (balance, account_number, customer_id) values (?, ?, ?)";

        try (Connection connection = ConnectionUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setInt(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.setInt(3, account.getCustomerId());

            if(preparedStatement.executeUpdate() == 1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Account> readAll() {
        String sql = "select * from account";
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                Account account = new Account();

                account.setBalance(resultSet.getInt("balance"));
                account.setAccountNumber(resultSet.getInt("account_number"));
                account.setCustomerId(resultSet.getInt("customer_id"));

                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public Account readByNumber(Account account) {
        String sql = "select * from account where account_number = ?";

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            account.setBalance(resultSet.getInt("balance"));
            account.setAccountNumber(resultSet.getInt("account_number"));
            account.setCustomerId(resultSet.getInt("customer_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public boolean update(Account account) {
        String sql = "update account set balance = ?, account_number = ?, customer_id = ? where account_number = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(4, account.getBalance());
            preparedStatement.setInt(5, account.getAccountNumber());
            preparedStatement.setInt(6, account.getCustomerId());

            if(preparedStatement.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Account account) {
        String sql = "delete from account where account_number = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "account_number");

            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}