package org.db.connecting;

import org.exceptions.ui.ExceptionUI;
import org.file.Writing;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class responsible for returning data from database
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public final class Data {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Method that returns ResultSet
     * @return ResultSet with all the data from DB from current table
     */
    public ResultSet getData() {
        // Writes log
        writing.writeLog(getClass(), "Getting all data from DB");

        // Initializes resultSet
        ResultSet resultSet = null;

        try {
            // Gets DB reference
            Statement statement = Connection.getConnection().createStatement();

            // Gets data from DB
            resultSet = statement.executeQuery("SELECT * FROM " + SQL.getCurrentTable());

        } catch (Exception ignored) {
            // If something went wrong informs user about this
            writing.writeLog(getClass(), " -> ExceptionUI");
            new ExceptionUI(getClass(), "Something went wrong when extracting data from database");
        }

        // Returns data
        return resultSet;
    }
}
