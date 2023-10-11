package org.manage;

public class StringOperations {
    public static void addQuestion(String chain){
        // Prepares chain of string to be sent to DB

        String question = chain.substring(0, chain.indexOf(";"));
        String answer = chain.substring(chain.indexOf(";")+1, chain.lastIndexOf(";"));
        String type = chain.substring(chain.indexOf(",")+1);

        question.trim();
        answer.trim();
        type.trim();

        Adding.add(question,answer,type);
    }
}
