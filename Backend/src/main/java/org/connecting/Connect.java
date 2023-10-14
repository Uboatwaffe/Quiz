package org.connecting;

import org.exceptions.ExceptionUI;
import org.manage.SQL;
import java.sql.*;

public final class Connect {
    public ResultSet getConnection() {
        ResultSet resultSet = null;

        try {
            // Getting connection to DB
            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;

            // Executing query
            resultSet = statement.executeQuery("SELECT * FROM " + SQL.getCurrentTable());

        } catch (SQLException ignored) {
            new ExceptionUI();
        }
        return resultSet;
    }
}
