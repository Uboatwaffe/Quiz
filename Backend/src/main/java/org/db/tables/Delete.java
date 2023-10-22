package org.db.tables;

import org.db.connecting.Connection;
import org.db.manage.SQL;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class that is responsible for deleting tables from the DB
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public class Delete{

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();


    /**
     * Method that deletes table from the DB
     * @param name Name of the table that will be deleted
     */
    public static void delete(String name) {
        try {
            // Writes log
            writing.writeLog(Delete.class, "Deleting table");

            // Queries
            String sql = "DROP TABLE `quiz`.`" + name + "`;";
            String sql2 = "DELETE FROM `quiz`.`tables` WHERE (`name` = '" + name + "');";

            // Executing query nr 1
            PreparedStatement statement2 = Connection.getConnection().prepareStatement(sql);
            statement2.executeUpdate();

            // Executing query nr 2
            PreparedStatement statement3 = Connection.getConnection().prepareStatement(sql2);
            statement3.executeUpdate();

            // Sets current table to 'set1'
            SQL.setCurrentTable(SQL.getAllTables()[0]);
        } catch (SQLException | NullPointerException e) {
            writing.writeLog(Delete.class, " -> ExceptionUI");
            new ExceptionUI(Delete.class);
        }
    }
}
