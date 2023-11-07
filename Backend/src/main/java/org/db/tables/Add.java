package org.db.tables;

import org.db.connecting.Connection;
import org.db.connecting.SQL;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;

import java.sql.PreparedStatement;

/**
 * Class that is responsible for adding new tables into the DB
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public final class Add{

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();


    /**
     * Method that adds new table to the DB
     * @param name Name of the new table
     */
    public static void add(String name){

        try {
            // Writes log
            writing.writeLog(Add.class, "Adding tables");

            // Queries
            String sql = "CREATE TABLE `quiz`.`"+ name +"` (`id` INT NOT NULL,`question` VARCHAR(90) NOT NULL,`answer` VARCHAR(45) NOT NULL,`type` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`))";
            String sql2 = "INSERT INTO tables VALUES ('"+ name +"')";

            // Executing query nr 1
            PreparedStatement statement2 = Connection.getConnection().prepareStatement(sql);
            statement2.executeUpdate();

            // Executing query nr 2
            PreparedStatement statement3 = Connection.getConnection().prepareStatement(sql2);
            statement3.executeUpdate();

            SQL.setCurrentTable(SQL.getAllTables()[SQL.getAllTables().length-1]);
        } catch (Exception ignore) {
            writing.writeLog(Add.class, " -> ExceptionUI");
            new ExceptionUI(Add.class, "Something went wrong while adding new table to the database");
        }
    }
}
