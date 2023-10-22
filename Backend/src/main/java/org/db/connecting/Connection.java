package org.db.connecting;

import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for establishing connection with database
 * @author Maciej
 * @version 0.1
 */
public final class Connection {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Method that establishes connection to the DB
     * @return Connection reference to database
     */
    public static java.sql.Connection getConnection() {

        // Writes log
        writing.writeLog(Connection.class, "Establishing connection to DB");

        try {

            // Establishes connection with DB and returns it
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "password");

        }catch (SQLException ignore){
            // If something went wrong informs user about this
            new ExceptionUI(Connection.class);

            // Doesn't return connection
            return null;
        }
    }
}
