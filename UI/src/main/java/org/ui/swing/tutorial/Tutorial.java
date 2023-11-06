package org.ui.swing.tutorial;

import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for showing tutorial to user
 *
 * @author Maciej
 * @version 0.2
 */
public class Tutorial extends JFrame {

    /**
     * Content of the frame
     */
    private JButton understood;

    /**
     * Content of the frame
     */
    private JLabel welocme;

    /**
     * Content of the frame
     */
    private JLabel types;

    /**
     * Content of the frame
     */
    private JLabel closed;

    /**
     * Content of the frame
     */
    private JLabel true_or_false;

    /**
     * Content of the frame
     */
    private JLabel date;

    /**
     * Content of the frame
     */
    private JLabel open;

    /**
     * Content of the frame
     */
    private JPanel panel;


    /**
     * Object used to write log
     *
     * @see Writing
     */
    Writing writing = new Writing();

    /**
     * Constructor
     */
    public Tutorial() {
        writing.writeLog(Tutorial.class, "Constructor()");

        setContentPane(panel);
        setTitle("Tutorial");
        setSize(440, 230);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        understood.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Tutorial.class, " <- Close");
                dispatchEvent(new WindowEvent(Tutorial.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
