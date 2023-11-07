package org.ui.swing.admin;

import org.annotation.UI;
import org.db.manage.Sorting;
import org.db.manage.ToStrings;
import org.file.Writing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Class that is responsible for showing all questions
 *
 * @author Maciej
 * @version 0.2
 */
@UI
public class ShowQ extends JFrame {

    /**
     * Field that gets questions from the DB
     */
    private final ToStrings toStrings = new ToStrings();

    /**
     * Content of the frame
     */
    private JButton reload;

    /**
     * Content of the frame
     */
    private JList<String> list;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Field used by JList
     */
    private final DefaultListModel<String> def;

    /**
     * Field used by JList
     */
    private final ArrayList<String> sets;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
    public ShowQ() {
        writing.writeLog(ShowQ.class, "Constructor()");


        setContentPane(panel);
        setTitle("All questions");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());

        sets = new ArrayList<>();
        def = new DefaultListModel<>();
        list.setModel(def);

        addData();
        reload.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(ShowQ.class, " -> Sorting");
                Sorting sorting = new Sorting();
                sorting.sort();
                writing.writeLog(ShowQ.class, "Reloading data");
                addData();
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(ShowQ.class, " <- Close");
                dispatchEvent(new WindowEvent(ShowQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

    /**
     * Method that adds elements to the ArrayList
     */
    @SuppressWarnings("CollectionAddedToSelf")
    private void addData() {
        sets.removeAll(sets);
        sets.addAll(Arrays.asList(toStrings.questionsInStringArray()));
        refreshData();
    }

    /**
     * Method that refreshes content of JList
     */
    private void refreshData() {
        def.removeAllElements();
        for (String x : sets) {
            def.addElement(x);
        }
    }
}
