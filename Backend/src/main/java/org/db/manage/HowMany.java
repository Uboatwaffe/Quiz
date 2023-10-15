package org.db.manage;

import org.db.connecting.Connect;
import org.exceptions.ExceptionUI;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Maciej
 * @version 0.1
 */
public class HowMany {
    private final Connect connect = new Connect();

    /**
     * @return Integer with value of number of records in current table
     */
    public int howMany(){
        // Returns number of records in current set

        ResultSet resultSet = connect.getConnection();
        int i = 0;
        try {
            while (resultSet.next()) i++;
        }catch (SQLException ignore){
            new ExceptionUI();
        }
        return i;
    }

    /**
     * @return Integer with value of highest index in current table
     */
    public int highest(){
        // Returns the highest id of records from current set

        ResultSet resultSet = connect.getConnection();
        int i = 0;
        try {
            while (resultSet.next()) {
                i = Integer.parseInt(resultSet.getString("id"));
            }
        }catch (SQLException ignore){
            new ExceptionUI();
        }
        return i;
    }
}
