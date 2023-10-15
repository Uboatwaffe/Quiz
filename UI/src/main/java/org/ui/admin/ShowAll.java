package org.ui.admin;

import org.db.manage.Sorting;
import org.db.manage.ToStrings;
import org.file.writing.Writing;

import javax.swing.*;
import java.io.IOException;

/**
 * UI for showing log.txt and answers
 * @author Maciej
 * @version 0.1
 */
class ShowAll {
    // UI responsible for showing log.txt and answers
    private final ToStrings toStrings = new ToStrings();
    private final Sorting sorting = new Sorting();
    private final static Writing writing = new Writing();
    public void ShowQuestions() {
        writing.writeLog(getClass(), "Showing questions");
        sorting.sort();

        JFrame frame = new JFrame("Here are all of the log.txt: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);

        JList<String> list = new JList<>(toStrings.questionsInStringArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jscrlp = new JScrollPane(list);

        // Adding to the frame
        frame.add(jscrlp);


        // Setting up the visibility
        frame.setVisible(true);
    }
    public void ShowAnswers() {
        writing.writeLog(getClass(), "Showing answers");
        sorting.sort();

        JFrame frame = new JFrame("Here are all of the answers: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);


        JList<String> list = new JList<>(toStrings.answersInStringArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jscrlp = new JScrollPane(list);

        // Adding to the frame
        frame.add(jscrlp);


        // Setting up the visibility
        frame.setVisible(true);
    }
}
