package org.ui.score;

import org.file.writing.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing that the answer given by the user was incorrect
 * @author Maciej
 * @version 0.1
 */
public class Incorrect implements ActionListener {
    // UI for informing user that his input was wrong
    private final JFrame frame = new JFrame("Quiz");
    private final static Writing writing = new Writing();

    /**
     * Constructor
     * @param answer Expected answer
     * @param wron Given answer
     */
    public Incorrect(String answer, @SuppressWarnings("SpellCheckingInspection") String wron) {
        writing.writeLog(getClass(), "Incorrect answer");

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("INCORRECT!");
        welcome.setBounds(180, 5, 150, 15);

        JLabel info = new JLabel("Correct answer was: ");
        info.setBounds(5, 25, 150, 15);

        JLabel score = new JLabel(answer);
        score.setBounds(130, 25, 400, 15);

        JLabel wrong = new JLabel("You inserted: " + wron);
        wrong.setBounds(5, 45, 400, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame.add(welcome);
        frame.add(info);
        frame.add(score);
        frame.add(understood);
        frame.add(wrong);

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
