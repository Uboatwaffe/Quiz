package org.db.connecting;

import org.exceptions.ExceptionUI;
import org.db.manage.SQL;
import java.sql.*;

/**
 * Class responsible for returning data from database
 * @author Maciej
 * @version 0.1
 */
public final class Connect {

    /**
     * @return ResultSet with all the data from DB for current table
     */
    public ResultSet getConnection() {
        ResultSet resultSet = null;

        try {
            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;

            resultSet = statement.executeQuery("SELECT * FROM " + SQL.getCurrentTable());

        } catch (SQLException ignored) {
            new ExceptionUI();
        }
        return resultSet;
    }
}
