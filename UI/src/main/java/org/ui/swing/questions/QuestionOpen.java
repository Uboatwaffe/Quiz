package org.ui.swing.questions;

import org.file.Writing;
import org.score.Count;
import org.ui.swing.score.Correct;
import org.ui.swing.score.Incorrect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing open questions
 * @author Maciej
 * @version 0.1
 */
public class QuestionOpen implements ActionListener {
    /**
     * Field that stores user's answer
     */
    private final String answer;

    /**
     * Frame of the class
     */
    private final JFrame frame = new JFrame("Quiz");

    /**
     * Text field for the answer
     */
    private final JTextField field = new JTextField("This is an open question", 10);

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
    public QuestionOpen(String quest, String answer) {
        //Writes log
        writing.writeLog(getClass(), "Constructor()");

        // Assigns answer
        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,210);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 400, 15);

        // Button
        JButton submit = new JButton("SUBMIT");
        JButton no = new JButton("I DO NOT KNOW");

        // Setting bounds
        submit.setBounds(5, 65, 415, 60);
        no.setBounds(5, 130, 415, 35);

        // Adding action listeners
        submit.addActionListener(this);
        no.addActionListener(this);


        // Text-field
        field.setBounds(5, 25, 415, 30);

        // Adding to the frame
        frame.add(question);
        frame.add(field);
        frame.add(submit);
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
            if (e.getActionCommand().equals("SUBMIT")) {
                if (field.getText().equals(this.answer)) {
                    Count.setCount(Count.getCount() + 1);
                    new Correct(Count.getCount());
                } else
                    new Incorrect(answer, field.getText());
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