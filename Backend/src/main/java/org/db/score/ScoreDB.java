package org.db.score;

import org.db.connecting.Connecting;
import org.db.manage.SQL;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that is responsible for giving stats about current set
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public class ScoreDB {
    static private String[] db;
    private static final Writing writing = new Writing();

    /**
     * @return String array with all the info about current set
     */
    public static String[] getStats() {

        try {
            writing.writeLog(ScoreDB.class, "Getting stats");

            Statement statement = Connecting.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM score WHERE name ='" + SQL.getCurrentTable() + "'");

            int i = 0;

            while (resultSet.next()) i++;

            db = new String[3];

            resultSet = statement.executeQuery("SELECT * FROM score");

            while (resultSet.next()){
                db[0] = resultSet.getString("attempts");
                db[1] = resultSet.getString("points");
                db[2] = resultSet.getString("allPoints");
            }

        } catch (SQLException ignore) {
            new ExceptionUI(ScoreDB.class);
        }

        return db;

    }

    /**
     * NOT USED
     * @param points Sets points to given value
     */
    public static void setStats(String points) {

        String[] db = getStats();

        String sql = "UPDATE `quiz`.`score` SET `attempts` = '"+ (Integer.parseInt(db[0])+1) +"', `points` = '"+ points +"', `allPoints` = '"+ (Integer.parseInt(db[2])+Integer.parseInt(points)) +"' WHERE (`name` = '"+ SQL.getCurrentTable() +"');";

        try {
            writing.writeLog(ScoreDB.class, "Setting stats");

            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(ScoreDB.class);
        }
    }

}

