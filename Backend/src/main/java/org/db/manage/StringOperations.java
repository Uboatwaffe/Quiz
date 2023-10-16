package org.db.manage;

import org.db.interfaces.Functional;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

/**
 * @author Maciej
 * @version 0.1
 */
public class StringOperations {
    private static final Writing writing = new Writing();

    /**
     * Method that calls Adding.add() for given data
     * @param chain String containing question, answer and type
     */
    public static void addQuestion(Functional functional, String chain){
        try {
            writing.writeLog(StringOperations.class, "Goto Adding");

            String[] db = functional.toArray(chain);

            String question = db[0];
            String answer = db[1];
            String type = db[2];

            if (type.equals("o") || type.equals("c") || type.equals("d") || type.equals("t"))
                Adding.add(question, answer, type);
            else
                new ExceptionUI(StringOperations.class);
        }catch (Exception ignore){
            new ExceptionUI(StringOperations.class);
        }
    }
}
