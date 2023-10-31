package org.ui.questions;

import org.file.Writing;
import org.score.Count;
import org.ui.score.Correct;
import org.ui.score.Incorrect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing true or false questions
 * @author Maciej
 * @version 0.1
 */
public class QuestionTrueOrFalse implements ActionListener {
    /**
     * Frame of the class
     */
    private final JFrame frame = new JFrame("Quiz");

    /**
     * Field that stores user's answer
     */
    private final String answer;

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * Constructor
     * @param quest String with question
     * @param answer String with expected answer
     */
    public QuestionTrueOrFalse(String quest, String answer) {
        //Writes log
        writing.writeLog(getClass(),"Constructor()");

        // Assigns answer
        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,200);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 400, 15);

        // Buttons
        JButton t = new JButton("TRUE");
        JButton f = new JButton("FALSE");
        JButton no = new JButton("I DO NOT KNOW");

        // Setting bounds
        t.setBounds(5, 45, 200, 70);
        f.setBounds(210, 45, 200, 70);
        no.setBounds(5, 120, 405, 35);

        // Adding action listeners
        t.addActionListener(this);
        f.addActionListener(this);
        no.addActionListener(this);



        // Adding to the frame
        frame.add(question);
        frame.add(t);
        frame.add(f);
        frame.add(no);

        // Setting up the visibility
        frame.setVisible(true);
    }
    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!e.getActionCommand().equals("I DO NOT KNOW")) {

            // If answer is correct lets know user and adds 1 point to the score
            writing.writeLog(getClass(), " <- Closing");
            if (e.getActionCommand().equals(answer)) {
                Count.setCount(Count.getCount() + 1);
                new Correct(Count.getCount());
            } else {
                new Incorrect(answer, e.getActionCommand());
            }

            // Closes this window
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        }else{
            // Writes log and closes this window
            writing.writeLog(getClass()," <- Closing, Don't know the answer");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
