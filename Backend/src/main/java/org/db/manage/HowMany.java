package org.db.manage;

import org.db.connecting.Connect;
import org.exceptions.ExceptionUI;
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
     * @see Connect
     */
    private final Connect connect = new Connect();

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * @return Integer with value of number of records in current table
     */
    public int howMany(){
        // Returns number of records in current set
        int i = 0;
        try {
            ResultSet resultSet = connect.getConnection();
            writing.writeLog(HowMany.class, "Counts how many records");


            while (resultSet.next()) i++;
        }catch (SQLException ignore){
            new ExceptionUI(getClass());
        }
        return i;
    }

    /**
     * @return Integer with value of highest index in current table
     */
    public int highest() {
        // Returns the highest id of records from current set
        int i = 0;
        try {
            writing.writeLog(HowMany.class, "Gets highest id of all records");

            ResultSet resultSet = connect.getConnection();

            while (resultSet.next()) {
                i = Integer.parseInt(resultSet.getString("id"));
            }
        } catch (SQLException ignore) {
            new ExceptionUI(getClass());
        }
        return i;
    }
}
