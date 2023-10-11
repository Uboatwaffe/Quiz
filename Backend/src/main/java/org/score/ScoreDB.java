package org.score;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.manage.SQL;

import java.sql.PreparedStatement;
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
            new ExceptionUI();
        }

        return db;

    }
    public static void setStats(String points) {
        String[] db = getStats();

        String sql = "UPDATE `quiz`.`score` SET `attempts` = '"+ (Integer.parseInt(db[0])+1) +"', `points` = '"+ points +"', `allPoints` = '"+ (Integer.parseInt(db[2])+Integer.parseInt(points)) +"' WHERE (`name` = '"+ SQL.getCurrentTable() +"');";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI();
        }
    }

}

