package org.tables;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.manage.SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public static void delete(String name) {

        try {

            String sql = "DROP TABLE `quiz`.`" + name + "`;";
            String sql2 = "DELETE FROM `quiz`.`tables` WHERE (`name` = '" + name + "');";
            String sql3 = "DELETE FROM `quiz`.`score` WHERE (`name` = '" + name + "');";


            PreparedStatement statement2 = Connecting.getConnection().prepareStatement(sql);
            statement2.executeUpdate();

            PreparedStatement statement3 = Connecting.getConnection().prepareStatement(sql2);
            statement3.executeUpdate();

            PreparedStatement statement4 = Connecting.getConnection().prepareStatement(sql3);
            statement4.executeUpdate();

            SQL.setCurrentTable(SQL.getAllTables()[0]);
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI();
        }
    }
}
