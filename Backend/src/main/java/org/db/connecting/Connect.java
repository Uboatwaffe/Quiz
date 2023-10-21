package org.db.connecting;

import org.exceptions.ExceptionUI;
import org.db.manage.SQL;
import org.file.writing.Writing;

import java.sql.*;

/**
 * Class responsible for returning data from database
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public final class Connect {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();
    /**
     * @return ResultSet with all the data from DB from current table
     */
    public ResultSet getConnection() {
        writing.writeLog(getClass(), "Getting all data from DB");
        ResultSet resultSet = null;

        try {
            //noinspection DataFlowIssue
            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;

            resultSet = statement.executeQuery("SELECT * FROM " + SQL.getCurrentTable());

        } catch (SQLException | NullPointerException ignored) {
            new ExceptionUI(getClass());
        }
        return resultSet;
    }
}
