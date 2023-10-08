package org.connecting;

import java.sql.*;

public class Connect {
    public ResultSet getConnection() {
        ResultSet resultSet = null;

        try {

            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;
            resultSet = statement.executeQuery("SELECT * FROM set1");

        } catch (SQLException ignored) {

        }
        return resultSet;
    }
}
