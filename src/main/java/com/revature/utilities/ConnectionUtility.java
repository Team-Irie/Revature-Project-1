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

        String url = "jdbc:postgresql://35.224.134.48:5432/postgres";
        String userName = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        return DriverManager.getConnection(url, userName, password);
    }
}