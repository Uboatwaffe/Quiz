package org.ui.hq;

import org.db.connecting.Connect;
import org.exceptions.ExceptionUI;
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
     * @see Connect
     */
    private final Connect connect = new Connect();

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
            writing.writeLog(getClass(), "Starts showing questions");

            ResultSet resultSet = connect.getConnection();
            if (resultSet != null) {
                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    writing.writeLog(getClass(), "Showing question with type: " + type);
                    switch(type){
                        case "d" -> new QuestionDate(resultSet.getString("question"), resultSet.getString("answer"));
                        case "c" -> new QuestionABC(resultSet.getString("question"), resultSet.getString("answer"));
                        case "o" -> new QuestionOpen(resultSet.getString("question"), resultSet.getString("answer"));
                        case "t" -> new QuestionTrueOrFalse(resultSet.getString("question"), resultSet.getString("answer"));
                        default -> new ExceptionUI(getClass());
                    }
                }
            }
            writing.writeLog(getClass(), "All questions showed");
        }catch (SQLException ignored){
            new ExceptionUI(getClass());
        }
    }
}
