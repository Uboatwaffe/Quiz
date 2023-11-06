package org.ui.swing.tutorial;

import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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

    Writing writing = new Writing();
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
             *
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
