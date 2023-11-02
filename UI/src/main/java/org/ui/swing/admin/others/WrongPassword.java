package org.ui.swing.admin.others;

import org.file.Writing;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing that inserted password/login was incorrect
 * @author Maciej
 * @version 0.1
 */
public class WrongPassword implements ActionListener {

    /**
     * Frame of the class
     */
    private final JFrame frame = new JFrame("Quiz");

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * MainSwing class
     */
    private final MainSwing mainSwing = new MainSwing();
    /**
     * Constructor
     */
    public WrongPassword() {
        // Writing log
        writing.writeLog(getClass(), "Constructor()");

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("UNFORTUNATELY");
        welcome.setBounds(160, 5, 150, 15);

        JLabel info = new JLabel("Your login or password was incorrect");
        info.setBounds(100, 25, 300, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame.add(welcome);
        frame.add(info);
        frame.add(understood);

        // Setting up the visibility
        frame.setVisible(true);
    }


    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Writing log, showing mainSwing menu and closing this window
        writing.writeLog(getClass(), " <- Closing");
        mainSwing.showMainSwing();
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}