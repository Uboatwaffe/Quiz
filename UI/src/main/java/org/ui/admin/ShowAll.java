package org.ui.admin;

import org.manage.Sorting;
import org.manage.ToStrings;

import javax.swing.*;

class ShowAll {

    ToStrings toStrings = new ToStrings();
    Sorting sorting = null;

    public void ShowQuestions() {

        //sorting = new Sorting();

        JFrame frame = new JFrame("Here are all of the questions: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);

        //sorting.clear();
        //sorting.sort();

        //sorting = null;

        JList<String> list = new JList<>(toStrings.questionsInStringArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jscrlp = new JScrollPane(list);

        // Adding to the frame
        frame.add(jscrlp);


        // Setting up the visibility
        frame.setVisible(true);
    }
    public void ShowAnswers() {
        //sorting = new Sorting();

        JFrame frame = new JFrame("Here are all of the answers: ");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);

        //sorting.clear();
        //sorting.sort();

        //sorting = null;

        JList<String> list = new JList<>(toStrings.answersInStringArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jscrlp = new JScrollPane(list);

        // Adding to the frame
        frame.add(jscrlp);


        // Setting up the visibility
        frame.setVisible(true);
    }
}
