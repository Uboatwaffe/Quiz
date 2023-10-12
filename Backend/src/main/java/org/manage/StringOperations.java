package org.manage;

import org.exceptions.ExceptionUI;

public class StringOperations {
    public static void addQuestion(String chain){
        // Prepares chain of string to be sent to DB

        try {
            String question = chain.substring(0, chain.indexOf(";"));
            String answer = chain.substring(chain.indexOf(";") + 1, chain.lastIndexOf(";"));
            String type = chain.substring(chain.indexOf(",") + 1);

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
