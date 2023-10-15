package org.manage;

import org.exceptions.ExceptionUI;

/**
 * @author Maciej
 * @version 0.1
 */
public class StringOperations {

    /**
     * Method that calls Adding.add() for given data
     * @param chain String containing question, answer and type
     */
    public static void addQuestion(Functional functional, String chain){
        try {

            String[] db = functional.toArray(chain);

            String question = db[0];
            String answer = db[1];
            String type = db[2];

            if (type.equals("o") || type.equals("c") || type.equals("d") || type.equals("t"))
                Adding.add(question, answer, type);
            else
                throw new RuntimeException();
        }catch (Exception ignore){
            new ExceptionUI();
        }
    }
}
