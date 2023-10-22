package org.db.manage;

import org.db.interfaces.Functional;
import org.db.interfaces.Functional2;
import org.exceptions.exceptions.CustomException;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

/**
 * Class that works on String chains and send it to the adding class
 * @see Adding
 * @author Maciej
 * @version 0.1
 */
public class StringOperations {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Method that calls Adding.add() for given data
     * @param chain String containing question, answer and type
     * @param functional Gets String chain into String array
     * @param functional2 Checks if type of questions is correct
     */
    public static void addQuestion(Functional functional, Functional2 functional2, String chain){
        try {
            // Writes log
            writing.writeLog(StringOperations.class, " -> Adding");

            // Gets string chain into array
            String[] db = functional.toArray(chain);

            // Checks if type of question isn't forbidden
            boolean correct = functional2.checkingExtensions(chain);

            // If everything is alright adds question to the DB
            if (correct)
                Adding.add(db[0], db[1], db[2]);
            else
                throw new CustomException(StringOperations.class, "Type of question is incorrect!");
        }catch (CustomException ignore){
            writing.writeLog(StringOperations.class, " -> ExceptionUI");
            new ExceptionUI(StringOperations.class);
        }
    }
}
