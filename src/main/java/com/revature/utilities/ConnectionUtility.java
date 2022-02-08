package com.revature.utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionUtility {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String ip = "";
        String userName = "";
        String password = "";

        String url = "jdbc:postgresql://" + ip + ":5432/postgres";
        System.out.println(url);
        System.out.println(userName);
        System.out.println(password);

        return DriverManager.getConnection(url, userName, password);
    }
}