package org.connecting;

import org.exceptions.ExceptionUI;

import java.sql.SQLException;
import java.sql.Statement;

public class LoggingIn {
    public static String[] getLoginAndPassword() {
        java.sql.ResultSet resultSet = null;

        String[] db = new String[3];

        try {

            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;
            resultSet = statement.executeQuery("SELECT * FROM admin");

            while(resultSet.next()){
                db[0] = resultSet.getString("login");
                db[1] = resultSet.getString("password");
                db[2] = resultSet.getString("user");
            }

        } catch (SQLException ignored) {
            new ExceptionUI();
        }
        return db;
    }
}
