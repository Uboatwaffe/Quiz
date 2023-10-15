package org.db.connecting;

import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class responsible for checking if login/password is correct
 * @author Maciej
 * @version 0.1
 */
public final class LoggingIn {
    private static final Writing writing = new Writing();

    /**
     * @return String array with password and login used by user 'admin'
     */
    public static String[] getLoginAndPassword() throws IOException {
        writing.writeLog(LoggingIn.class, "Getting data to logging in");
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

        } catch (SQLException | IOException ignored) {
            new ExceptionUI(LoggingIn.class);
        }
        return db;
    }
}
