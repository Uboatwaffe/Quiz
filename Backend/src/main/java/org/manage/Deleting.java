package org.manage;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleting {

    public static void delete(String index) {
        String sql = "DELETE FROM "+ SQL.getCurrentTable() +" WHERE id='" + index +"'";
        if(index.equals("-1")) {
            sql = "DELETE FROM " + SQL.getCurrentTable();
        }
            try {
                PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException | NullPointerException e) {
                new ExceptionUI();
            }


    }
}
