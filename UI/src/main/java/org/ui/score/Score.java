package org.ui.score;

import org.file.writing.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing that the answer given by the user was correct
 * @author Maciej
 * @version 0.1
 */
public class Score implements ActionListener {
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
     * @param sc Current score
     */
    public Score(int sc) {
        writing.writeLog(getClass(), "Correct answer");

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("CORRECT!");
        welcome.setBounds(180, 5, 150, 15);

        JLabel info = new JLabel("Your score equals: ");
        info.setBounds(155, 25, 150, 15);

        JLabel score = new JLabel(String.valueOf(sc));
        score.setBounds(200, 45, 150, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame.add(welcome);
        frame.add(info);
        frame.add(score);
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
        writing.writeLog(getClass(), "Closing");
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
