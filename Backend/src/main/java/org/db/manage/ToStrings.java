package org.db.manage;

import org.db.connecting.Connect;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that extracts answers and questions from DB
 * @author Maciej
 * @version 0.1
 */
public class ToStrings {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * @return String array with all the questions
     */
    public String[] questionsInStringArray() {
        writing.writeLog(getClass(), "Getting questions in array");

        Connect connect = new Connect();
        HowMany howMany = new HowMany();

        String[] db = new String[howMany.howMany()];
        int i = 0;
        try {
        ResultSet resultSet = connect.getConnection();


            while (resultSet.next()) {
                db[i++] = resultSet.getString("id") + ") " + resultSet.getString("question");
            }
        }catch (SQLException ignore){
            new ExceptionUI(getClass());
        }

        return db;
    }

    /**
     * @return String array with all answers
     */
    public String[] answersInStringArray() {
        writing.writeLog(getClass(), "Getting answers in array");

        // Returns all answers from current set

        Connect connect = new Connect();
        HowMany howMany = new HowMany();

        String[] db = new String[howMany.howMany()];
        int i = 0;
        try {
        ResultSet resultSet = connect.getConnection();


            while (resultSet.next()) {
                db[i++] = resultSet.getString("id") + ") " + resultSet.getString("answer");
            }
        }catch (SQLException ignore){
            new ExceptionUI(getClass());
        }

        return db;
    }
}
