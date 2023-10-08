package org.manage;

import org.connecting.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sorting {
    HowMany howMany = new HowMany();
    Connect connect = new Connect();
    int x = howMany.howMany();
    String[][] db = new String[x+1][3];
    public void sort(){
        ResultSet resultSet = connect.getConnection();
        int i = 0;
        try {
            while (resultSet.next()) {
                db[i][0] = resultSet.getString("question");
                db[i][1] = resultSet.getString("answer");
                db[i][2] = resultSet.getString("type");
                i++;
            }
        }catch (SQLException ignore){}
        Deleting.delete("-1");
        i = 0;
        while (i < x) {
            Adding.add(String.valueOf(i+1), db[i][0], db[i][1], db[i][2]);
            i++;
        }
    }
}

