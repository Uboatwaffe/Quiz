package org.connecting;

import java.sql.*;

public class Connect {
    public ResultSet getConnection() {
        ResultSet resultSet = null;

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "password");

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM set1");

        } catch (SQLException ignored) {

        }
        return resultSet;
    }
}
