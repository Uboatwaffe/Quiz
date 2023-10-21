package org.db.tables;

import org.db.connecting.Connecting;
import org.db.manage.SQL;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public class Delete{
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


            PreparedStatement statement2 = Connecting.getConnection().prepareStatement(sql);
            statement2.executeUpdate();

            PreparedStatement statement3 = Connecting.getConnection().prepareStatement(sql2);
            statement3.executeUpdate();

            SQL.setCurrentTable(SQL.getAllTables()[0]);
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(Delete.class);
        }
    }
}
