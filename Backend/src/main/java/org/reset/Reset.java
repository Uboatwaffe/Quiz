package org.reset;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.manage.Adding;
import org.manage.ChangePassword;
import org.manage.Deleting;
import org.manage.SQL;
import org.tables.Delete;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reset {
    // Resets all data
    private static final String[] tableNames = SQL.getAllTables();
    private static final String[] db1 = {"True or False", "Close question", "Open question", "Question about date"};
    private static final String[] db2 = {"TRUE", "A", "YES", "11.11.1111"};
    private static final String[] db3 = {"t", "c", "o", "d"};

    public static void reset(){
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
    private static void resetScore(){
        try {

            String sql = "UPDATE `quiz`.`score` SET `attempts` = '"+ 0 +"', `points` = '"+ 0 +"', `allPoints` = '"+ 0 +"' WHERE (`name` = '"+ SQL.getCurrentTable() +"');";


            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI();
        }
    }
}
