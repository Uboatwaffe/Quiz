package org.db.manage;

import org.db.connecting.Connect;
import org.exceptions.ExceptionUI;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Maciej
 * @version 0.1
 */
public class ToStrings {

    /**
     * @return String array with all the questions
     */
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

    /**
     * @return String array with all answers
     */
    public String[] answersInStringArray(){
        // Returns all answers from current set

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
