package org.connecting;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToStrings {
    public String[] questionsInStringArray(){
        Connect connect = new Connect();
        HowMany howMany = new HowMany();

        String[] db = new String[howMany.howMany()];
        int i = 0;

        ResultSet resultSet = connect.getConnection();

        try {
            while (resultSet.next()) {
                db[i++] = i + ") " + resultSet.getString("question");
            }
        }catch (SQLException ignore){}

        return db;
    }
    public String[] answersInStringArray(){
        Connect connect = new Connect();
        HowMany howMany = new HowMany();

        String[] db = new String[howMany.howMany()];
        int i = 0;

        ResultSet resultSet = connect.getConnection();

        try {
            while (resultSet.next()) {
                db[i++] = i + ") " + resultSet.getString("answer");
            }
        }catch (SQLException ignore){}

        return db;
    }
}
