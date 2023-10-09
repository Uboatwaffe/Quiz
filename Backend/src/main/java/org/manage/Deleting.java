package org.manage;
import org.connecting.Connecting;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleting {

    public static void delete(String index) {
        String sql = "DELETE FROM "+SQL.getCurrentTable()+" WHERE id='" + index +"'";
        if(index.equals("-1")) {
            sql = "DELETE FROM set1";
        }
            try {
                PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }


    }
}
