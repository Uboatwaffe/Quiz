package org.score;

import org.connecting.Connecting;
import org.manage.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDB {
    static ResultSet resultSet = null;
    static String[] db;

    public static String[] getStats() {
        try {
            Statement statement = Connecting.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM score WHERE name ='"+ SQL.getCurrentTable() +"'");

            int i = 0;

            while (resultSet.next()) i++;

            db = new String[3];

            resultSet = statement.executeQuery("SELECT * FROM score");

            i = 0;
            while (resultSet.next()){
                db[0] = resultSet.getString("attempts");
                db[1] = resultSet.getString("points");
                db[2] = resultSet.getString("allPoints");
            }

        } catch (SQLException ignore) {
        }

        return db;

    }

}

