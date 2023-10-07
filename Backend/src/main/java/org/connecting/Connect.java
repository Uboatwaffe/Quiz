package org.connecting;

import java.sql.*;

public class Connect {
    public void getConnection() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "password");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM set1");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("question"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
