package org.db.manage;

import org.db.connecting.Data;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class responsible for letting program know info about
 * how many records are in th DB and what is the highest 'id'
 * @author Maciej
 * @version 0.1
 */
public class HowMany {

    /**
     * Object used to establishing connection to the DB
     * @see Data
     */
    private final Data data = new Data();

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Method
     * @return Integer with value of number of records in current table
     */
    public int howMany(){
        int i = 0;

        try {
            // Gets data from DB
            ResultSet resultSet = data.getData();

            // Writes log
            writing.writeLog(HowMany.class, "Counts how many records");

            // Counts how many records there are
            while (resultSet.next()) i++;

        }catch (SQLException ignore){
            writing.writeLog(HowMany.class, " -> ExceptionUI");
            new ExceptionUI(getClass());
        }
        // Returns info
        return i;
    }

    /**
     * Method
     * @return Integer with value of highest index in current table
     */
    public int highest() {
        int i = 0;

        try {
            // Writes log
            writing.writeLog(HowMany.class, "Gets highest id of all records");

            // Gets data from DB
            ResultSet resultSet = data.getData();

            // Searches for highest index
            while (resultSet.next()) {
                i = Integer.parseInt(resultSet.getString("id"));
            }
        } catch (SQLException ignore) {
            writing.writeLog(HowMany.class, " -> ExceptionUI");
            new ExceptionUI(getClass());
        }
        // Returns info
        return i;
    }
}
