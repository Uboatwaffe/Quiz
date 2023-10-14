package org.connecting;

import org.exceptions.ExceptionUI;
import java.sql.SQLException;
import java.sql.Statement;

public final class LoggingIn {
    public static String[] getLoginAndPassword() {
        java.sql.ResultSet resultSet;

        String[] db = new String[3];

        try {
            // Getting connection to DB
            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;
            // Executing query
            resultSet = statement.executeQuery("SELECT * FROM admin");

            // Getting info from DB
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
