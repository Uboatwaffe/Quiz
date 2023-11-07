package org.db.connecting;

import org.annotation.DataBase;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class that stores info about tables in DB
 */
@SuppressWarnings("DataFlowIssue")
@DataBase
public class SQL {

    /**
     *  Sets default table at the beginning
     *  As the program sets new table this is where it is stored
     */
    private static String currentTable = getAllTables()[0];

    /**
     * Method
     * @param currentTable Sets current table to 'current table
     */
    public static void setCurrentTable(String currentTable) {
        SQL.currentTable = currentTable;
    }

    /**
     * Method
     * @return String with current table
     */
    public static String getCurrentTable() {
        return currentTable;
    }

    /**
     * Method
     * @return String array with names of all tables
     */
    public static String[] getAllTables(){

        // Initializes default table name
        String[] db = {"set1"};

        try {
            // Object
            final Writing writing = new Writing();

            // Writes log
            writing.writeLog(SQL.class, "Getting all tables names");

            // Gets connection reference to the DB
            Statement statement = Connection.getConnection().createStatement();

            // Gets info about names of the existing tables in the DB
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tables");

            int i = 0;

            // Counts how many there are
            while (resultSet.next()) i++;

            // Creates array in the size of how many records
            db = new String[i];

            // Gets all the info
            resultSet = statement.executeQuery("SELECT * FROM tables");

             i = 0;

             // Extracts info from DB into the array
            while (resultSet.next()){
                db[i++] = resultSet.getString("name");
            }

        } catch (Exception ignore) {
            new ExceptionUI(SQL.class, "Something went wrong while getting all names of tables in database");
        }

        // Returns array
        return db;
    }
}
