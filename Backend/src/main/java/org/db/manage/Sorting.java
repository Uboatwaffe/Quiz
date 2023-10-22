package org.db.manage;

import org.db.connecting.Data;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that sorts records in table
 * @author Maciej
 * @version 0.1
 */
public class Sorting {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Sorts whole DB
     */
    public void sort(){

        try {
            // Writes log
            writing.writeLog(Sorting.class, "Sorts");

            // Objects
            Data data = new Data();
            HowMany howMany = new HowMany();

            // Gets info from DB
            ResultSet resultSet = data.getData();

            // Arrays
            String[] questions = new String[howMany.howMany()];
            String[] answers = new String[howMany.howMany()];
            String[] types = new String[howMany.howMany()];

            int i = 0;

            // Extracting data from DB and putting it in corresponding array
            while(resultSet.next()){
                questions[i] = resultSet.getString("question");
                answers[i] = resultSet.getString("answer");
                types[i++] = resultSet.getString("type");
            }

            // Clears whole DB
            Deleting.delete("-1");

            // Inserts previously extracted data into DB without indexes
            for (int j = 0; j < i; j++) {
                Adding.add(questions[j], answers[j], types[j]);
            }
        }catch (SQLException ignore){
            new ExceptionUI(getClass());
        }
    }
}
