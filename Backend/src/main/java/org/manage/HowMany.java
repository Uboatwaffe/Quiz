package org.manage;

import org.connecting.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HowMany {
    Connect connect = new Connect();
    public int howMany(){
        ResultSet resultSet = connect.getConnection();
        int i = 0;
        try {
            while (resultSet.next()) i++;
        }catch (SQLException ignore){

        }
        return i;
    }
}
