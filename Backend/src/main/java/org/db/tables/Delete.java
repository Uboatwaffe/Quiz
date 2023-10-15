package org.db.tables;

import org.db.connecting.Connecting;
import org.db.manage.ChangePassword;
import org.db.manage.SQL;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maciej
 * @version 0.1
 */
public class Delete {
    private static final Writing writing = new Writing();


    /**
     * Method that deletes table from the DB
     * @param name Name of the table that will be deleted
     */
    public static void delete(String name) {
        try {
            writing.writeLog(Delete.class, "Deleting table");


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
        } catch (SQLException | NullPointerException | IOException e) {
            new ExceptionUI(Delete.class);
        }
    }
}
