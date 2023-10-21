package org.ui.questions;

import org.file.writing.Writing;
import org.ui.score.Incorrect;
import org.ui.score.Score;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing question about date
 * @author Maciej
 * @version 0.1
 */
public class QuestionDate implements ActionListener {
    /**
     * Field that stores user's answer
     */
    private final String answer;

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
     * Text filed for answer
     */
    private final JTextField field = new JTextField("This is question about date", 100);
    /**
     * Constructor
     * @param quest String with question
     * @param answer String with expected answer
     */
    public QuestionDate(String quest, String answer) {
        writing.writeLog(getClass(), "Question about date");

        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,210);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 150, 15);

        // Button
        JButton submit = new JButton("SUBMIT");
        JButton no = new JButton("I DO NOT KNOW");


        submit.setBounds(5, 65, 415, 60);
        no.setBounds(5, 130, 415, 35);

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
            try {
                writing.writeLog(getClass(), "Closing");
                if (e.getActionCommand().equals("SUBMIT")) {
                    if (field.getText().equals(this.answer)) {
                        Count.setCount(Count.getCount() + 1);
                        new Score(Count.getCount());
                    } else
                        new Incorrect(answer, field.getText());
                }

            } finally {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }else{
            writing.writeLog(getClass(),"Don't know the answer");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
