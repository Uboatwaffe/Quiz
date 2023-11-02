package org.ui.swing.tutorial;

import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing tutorial to user
 * @author Maciej
 * @version 0.1
 */
public class Tutorial implements ActionListener {
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
     * Constructor
     */
    public Tutorial() {
        //Writes log
        writing.writeLog(getClass(), "Constructor()");

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(210,250);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("Welcome to the tutorial!");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("There are 3 types of data input:");
        string2.setBounds(5,30, 200, 15);

        JLabel string3 = new JLabel("1) A, B, C, D just click the button");
        string3.setBounds(5,55, 200, 15);

        JLabel string4 = new JLabel("2) Date in format of DD.MM.YYYY");
        string4.setBounds(5,80, 200, 15);

        JLabel string5 = new JLabel("3) Open question should be");
        string5.setBounds(5,105, 200, 15);

        JLabel string6 = new JLabel("typed with CAPS LOCK");
        string6.setBounds(5,130, 200, 15);

        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 155, 185, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
        frame.add(string4);
        frame.add(string5);
        frame.add(string6);
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
        // Writes log and closes this window
        writing.writeLog(getClass(), " <- Closing");
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}