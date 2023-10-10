package org.reset;

import org.connecting.Connecting;
import org.manage.ChangePassword;
import org.manage.Deleting;
import org.manage.SQL;
import org.tables.Delete;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reset {
    static String[] tableNames = SQL.getAllTables();

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
            throw new RuntimeException(e);
        }
    }
}
