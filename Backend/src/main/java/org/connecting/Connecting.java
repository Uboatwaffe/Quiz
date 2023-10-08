package org.connecting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecting {
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "password");

            return connection;
        }catch (SQLException ignore){}
        return null;
    }
}
