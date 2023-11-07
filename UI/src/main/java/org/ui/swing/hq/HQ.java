package org.ui.swing.hq;

import org.db.connecting.Data;
import org.db.manage.HowMany;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;
import org.score.Count;
import org.ui.swing.exceptions.NoQuestions;
import org.ui.swing.questions.ClosedQuestion;
import org.ui.swing.questions.DateQuestion;
import org.ui.swing.questions.OpenQuestion;
import org.ui.swing.questions.TorFQuestion;
import org.ui.swing.score.FinalScore;

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
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Object that gets data from DB
     * @see Data
     */
    private final Data data = new Data();

    /**
     * Field that gets how many records are in database
     *
     * @see HowMany
     */
    HowMany howMany = new HowMany();
    /**
     * Method that calls other classes that show questions
     */
    public void start() {
        boolean any = true;
        try {
            Count.setCount(0);

            //Writes log
            writing.writeLog(getClass(), "Starts showing questions");

            // Gets data from DB
            ResultSet resultSet = data.getData();

            if (howMany.howMany() > 0) {
                writing.writeLog(HQ.class, " -> FinalScore");
                while (resultSet.next()) {
                    // Gets type of the question
                    String type = resultSet.getString("type");

                    //Writes log
                    writing.writeLog(getClass(), "Showing question with type: " + type);
                    if (any) {
                        any = false;
                        new FinalScore();
                    }

                    // Creates corresponding UI for type of the question
                    switch (type) {
                        case "d" -> new DateQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        case "c" -> new ClosedQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        case "o" -> new OpenQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        case "t" -> new TorFQuestion(resultSet.getString("question"), resultSet.getString("answer"));
                        default -> new ExceptionUI(getClass(), "Type of question wasn't correct");
                    }
                }
                //Writes log
                writing.writeLog(getClass(), "All questions showed");
            } else {
                new NoQuestions();
            }
        } catch (Exception ignored) {
            writing.writeLog(getClass(), " -> ExceptionUI");
            new ExceptionUI(getClass(), "Something went wrong with ResultSet from database");
        }
    }
}
