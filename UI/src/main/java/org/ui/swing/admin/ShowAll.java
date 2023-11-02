package org.ui.swing.admin;

import org.db.manage.Sorting;
import org.db.manage.ToStrings;
import org.file.Writing;

import javax.swing.*;

/**
 * UI for showing questions and answers
 * @author Maciej
 * @version 0.1
 */
class ShowAll {
    /**
     * Object responsible for preparing String chain
     */
    private final ToStrings toStrings = new ToStrings();

    /**
     * Object responsible for sorting DB
     */
    private final Sorting sorting = new Sorting();

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * Method that shows all the questions to user
     */
    void ShowQuestions() {
        // Writes log
        writing.writeLog(getClass(), "Showing questions");

        // Sorts DB
        sorting.sort();

        // Default settings
        JFrame frame = new JFrame("Here are all of the questions: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);

        // Initializing list and scroll panel
        JList<String> list = new JList<>(toStrings.questionsInStringArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jscrlp = new JScrollPane(list);

        // Adding to the frame
        frame.add(jscrlp);

        // Setting up the visibility
        frame.setVisible(true);
    }

    /**
     * Method that shows all the answers to user
     */
    void ShowAnswers() {
        // Writing log
        writing.writeLog(getClass(), "Showing answers");

        // Sorting DB
        sorting.sort();

        // Default settings
        JFrame frame = new JFrame("Here are all of the answers: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);

        // Initializing list and scroll panel
        JList<String> list = new JList<>(toStrings.answersInStringArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jscrlp = new JScrollPane(list);

        // Adding to the frame
        frame.add(jscrlp);


        // Setting up the visibility
        frame.setVisible(true);
    }
}
