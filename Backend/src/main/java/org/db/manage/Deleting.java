package org.db.manage;

import org.db.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class that deletes log.txt
 * @author Maciej
 * @version 0.1
 */
public class Deleting {
    private static final Writing writing = new Writing();

    /**
     * @param index Index of question that is going to be deleted, '-1' clears whole table
     */
    public static void delete(String index) {
        // Query
        String sql = "DELETE FROM "+ SQL.getCurrentTable() +" WHERE id='" + index +"'";

        // If index='-1' clears whole table
        if(index.equals("-1")) {
            sql = "DELETE FROM " + SQL.getCurrentTable();
        }
        try {
            writing.writeLog(Deleting.class, "Deleting question");

            // Executing query
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(Deleting.class);
        }


    }
}