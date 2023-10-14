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
    public static void addQuestion(String chain){
        try {
            String question = chain.substring(0, chain.indexOf(";"));
            String answer = chain.substring(chain.indexOf(";") + 1, chain.lastIndexOf(";"));
            String type = chain.substring(chain.lastIndexOf(";") + 1);

            question.trim();
            answer.trim();
            type.trim();

            if (type.equals("o") || type.equals("c") || type.equals("d") || type.equals("t"))
                Adding.add(question, answer, type);
            else
                throw new RuntimeException();
        }catch (Exception ignore){
            new ExceptionUI();
        }
    }
}
