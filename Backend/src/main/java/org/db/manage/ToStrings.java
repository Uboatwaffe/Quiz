package org.db.manage;

import org.db.connecting.Data;
import org.exceptions.ui.ExceptionUI;
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
     * Method
     * @return String array with all the questions
     */
    public String[] questionsInStringArray() {
        // Writes log
        writing.writeLog(getClass(), "Getting questions in array");

        // Objects
        Data data = new Data();
        HowMany howMany = new HowMany();

        // Creates array based on how many records are in DB
        String[] db = new String[howMany.howMany()];

        int i = 0;

        try {
            // Gets data
            ResultSet resultSet = data.getData();

            // Extracts questions from DB and puts them in array
            while (resultSet.next()) {
                db[i++] = resultSet.getString("id") + ") " + resultSet.getString("question");
            }
        }catch (SQLException ignore){
            new ExceptionUI(getClass());
        }
        // Returns array
        return db;
    }

    /**
     * Method
     * @return String array with all answers
     */
    public String[] answersInStringArray() {
        // Writes log
        writing.writeLog(getClass(), "Getting answers in array");

        // Objects
        Data data = new Data();
        HowMany howMany = new HowMany();

        // Creates array based on how many records are in DB
        String[] db = new String[howMany.howMany()];

        int i = 0;

        try {
            // Gets data
            ResultSet resultSet = data.getData();

            // Extracts answers from DB and puts them in array
            while (resultSet.next()) {
                db[i++] = resultSet.getString("id") + ") " + resultSet.getString("answer");
            }
        }catch (SQLException ignore){
            writing.writeLog(ToStrings.class, " -> ExceptionUI");
            new ExceptionUI(getClass());
        }

        // Returns array
        return db;
    }
}
