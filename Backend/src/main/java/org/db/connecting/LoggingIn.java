package org.db.connecting;

import org.annotation.DataBase;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class responsible for checking if login/password is correct
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
@DataBase
public final class LoggingIn {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Method that returns current login and password
     * @return String array with password and login used by user 'admin'
     */
    public static String[] getLoginAndPassword() {
        // Writes log
        writing.writeLog(LoggingIn.class, "Getting data to logging in");

        // Initializes result set
        ResultSet resultSet;

        // Creates Array for data
        String[] db = new String[3];

        try {
            // Getting connection to DB
            Statement statement = Connection.getConnection().createStatement();

            // Executing query
            resultSet = statement.executeQuery("SELECT * FROM admin");

            // Getting info from DB
            while(resultSet.next()){
                db[0] = resultSet.getString("login");
                db[1] = resultSet.getString("password");
                db[2] = resultSet.getString("user");
            }

        } catch (Exception ignored) {
            // If something went wrong informs user about this
            writing.writeLog(LoggingIn.class, " -> ExceptionUI");
            new ExceptionUI(LoggingIn.class, "Something went wrong while extracting data for logging in purposes");
        }
        // Returning info
        return db;
    }
}
