package org.manage;

import org.connecting.Connect;
import org.exceptions.ExceptionUI;
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
                db[i++] = resultSet.getString("id") + ") " + resultSet.getString("question");
            }
        }catch (SQLException ignore){
            new ExceptionUI();
        }

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
                db[i++] = resultSet.getString("id") + ") " + resultSet.getString("answer");
            }
        }catch (SQLException ignore){
            new ExceptionUI();
        }

        return db;
    }
}
