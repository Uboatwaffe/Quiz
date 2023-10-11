package org.manage;

import org.connecting.Connect;
import org.exceptions.ExceptionUI;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HowMany {
    private final Connect connect = new Connect();
    public int howMany(){
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
        ResultSet resultSet = connect.getConnection();
        int i = 0;
        try {
            while (resultSet.next()) {
                i = Integer.valueOf(resultSet.getString("id"));
            }
        }catch (SQLException ignore){
            new ExceptionUI();
        }
        return i;
    }
}
