package org.connecting;

import org.manage.SQL;

import java.sql.*;

public class Connect {
    public ResultSet getConnection() {
        ResultSet resultSet = null;

        try {

            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;
            resultSet = statement.executeQuery("SELECT * FROM " + SQL.getCurrentTable());

        } catch (SQLException ignored) {

        }
        return resultSet;
    }
}
