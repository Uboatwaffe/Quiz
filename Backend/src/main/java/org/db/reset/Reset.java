package org.db.reset;

import org.db.connecting.Connecting;
import org.db.manage.Deleting;
import org.db.manage.SQL;
import org.exceptions.ExceptionUI;
import org.db.manage.Adding;
import org.db.manage.ChangePassword;
import org.db.tables.Delete;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class that stores all default data
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public class Reset {
    private static final String[] tableNames = SQL.getAllTables();
    private static final String[] db1 = {"True or False", "Close question", "Open question", "Question about date"};
    private static final String[] db2 = {"TRUE", "A", "YES", "11.11.1111"};
    private static final String[] db3 = {"t", "c", "o", "d"};
    private static final Writing writing = new Writing();


    /**
     * Method that resets whole configuration
     */
    public static void reset() {
        writing.writeLog(Reset.class, "Reseting");

        String[] toDelete = new String[tableNames.length-1];
        int i = 0;

        for (String x:
             tableNames) {
            if(!x.equals("set1")){
                toDelete[i++] = x;
            }
        }

        SQL.setCurrentTable(SQL.getAllTables()[0]);
        Deleting.delete("-1");
        for (int j = 0; j < db1.length; j++) {
            Adding.add(db1[j], db2[j], db3[j]);
        }

        for (String x:
             toDelete) {
            Delete.delete(x);
        }

        ChangePassword.change("Login", "Password", "admin");

        resetScore();
    }

    /**
     * Method that resets score
     * NOT USED
     */
    private static void resetScore(){
        try {
            writing.writeLog(Reset.class, "Reseting score");

            String sql = "UPDATE `quiz`.`score` SET `attempts` = '"+ 0 +"', `points` = '"+ 0 +"', `allPoints` = '"+ 0 +"' WHERE (`name` = '"+ SQL.getCurrentTable() +"');";


            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(Reset.class);
        }
    }
}
