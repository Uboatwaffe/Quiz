package org.new_ui.swing.hq;

import org.db.connecting.Data;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;
import org.new_ui.swing.questions.ClosedQuestion;
import org.new_ui.swing.questions.DateQuestion;
import org.new_ui.swing.questions.OpenQuestion;
import org.new_ui.swing.questions.TorFQuestion;
import org.new_ui.swing.score.FinalScore;
import org.score.Count;

import java.sql.ResultSet;

/**
 * Class that has its own Thread
 *
 * @author Maciej
 * @version 0.1
 */
public class HQ extends Thread {

    /**
     * Object used to write log
     *
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Object that gets data from DB
     *
     * @see Data
     */
    private final Data data = new Data();

    /**
     * Method that calls other classes that show questions
     */
    public void start() {
        try {
            Count.setCount(0);

            //Writes log
            writing.writeLog(getClass(), "Starts showing questions");

            // Gets data from DB
            ResultSet resultSet = data.getData();

            if (resultSet != null) {
                new FinalScore();
                while (resultSet.next()) {
                    // Gets type of the question
                    String type = resultSet.getString("type");

                    //Writes log
                    writing.writeLog(getClass(), "Showing question with type: " + type);

                    // Creates corresponding UI for type of the question
                    switch (type) {
                        case "d" -> new DateQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        case "c" -> new ClosedQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        case "o" -> new OpenQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        case "t" -> new TorFQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        default -> new ExceptionUI(getClass());
                    }
                }
            }
            //Writes log
            writing.writeLog(getClass(), "All questions showed");
        } catch (Exception ignored) {
            writing.writeLog(getClass(), " -> ExceptionUI");
            new ExceptionUI(getClass());
        }
    }
}
