package org.manage;

import org.connecting.Connect;
import org.exceptions.ExceptionUI;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HowMany {
    private final Connect connect = new Connect();
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
