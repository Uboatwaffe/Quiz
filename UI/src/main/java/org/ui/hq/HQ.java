package org.ui.hq;

import org.db.connecting.Data;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;
import org.ui.questions.QuestionABC;
import org.ui.questions.QuestionDate;
import org.ui.questions.QuestionOpen;
import org.ui.questions.QuestionTrueOrFalse;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Class that has its own Thread
 * @author Maciej
 * @version 0.1
 */
public class HQ extends Thread{

    /**
     * Object that gets data from DB
     * @see Data
     */
    private final Data data = new Data();

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     *  Method that calls other classes that show questions
     */
    public void start(){
        try {
            //Writes log
            writing.writeLog(getClass(), "Starts showing questions");

            // Gets data from DB
            ResultSet resultSet = data.getData();

            if (resultSet != null) {
                while (resultSet.next()) {
                    // Gets type of the question
                    String type = resultSet.getString("type");

                    //Writes log
                    writing.writeLog(getClass(), "Showing question with type: " + type);

                    // Creates corresponding UI for type of the question
                    switch(type){
                        case "d" -> new QuestionDate(resultSet.getString("question"), resultSet.getString("answer"));
                        case "c" -> new QuestionABC(resultSet.getString("question"), resultSet.getString("answer"));
                        case "o" -> new QuestionOpen(resultSet.getString("question"), resultSet.getString("answer"));
                        case "t" -> new QuestionTrueOrFalse(resultSet.getString("question"), resultSet.getString("answer"));
                        default -> new ExceptionUI(getClass());
                    }
                }
            }
            //Writes log
            writing.writeLog(getClass(), "All questions showed");
        }catch (SQLException ignored){
            writing.writeLog(getClass(), " -> ExceptionUI");
            new ExceptionUI(getClass());
        }
    }
}
