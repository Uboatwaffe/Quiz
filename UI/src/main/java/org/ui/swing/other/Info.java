package org.ui.swing.other;

import org.db.manage.HowMany;
import org.db.manage.SQL;
import org.file.Writing;
import org.score.Count;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for showing info about current set
 *
 * @author Maciej
 * @version 0.2
 */
public class Info extends JFrame {

    /**
     * Field that gets info about how many records are in the DB
     */
    final HowMany howMany = new HowMany();

    /**
     * Content of the frame
     */
    private JButton understood;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JLabel INFO;

    /**
     * Content of the frame
     */
    private JLabel set;

    /**
     * Content of the frame
     */
    private JLabel questions;

    /**
     * Content of the frame
     */
    private JLabel last_score;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
    public Info() {
        writing.writeLog(Info.class, "Constructor()");

        setSize(210, 190);
        setContentPane(panel);
        setTitle("Info");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        last_score.setText("Last score: " + Count.getCount());
        set.setText("Current set id: " + SQL.getCurrentTable());
        questions.setText("Number of questions in it: " + howMany.howMany());
        understood.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Info.class, " <- Closing");
                dispatchEvent(new WindowEvent(Info.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}