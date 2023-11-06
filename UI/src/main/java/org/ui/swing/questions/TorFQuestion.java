package org.ui.swing.questions;

import org.file.Writing;
import org.score.Count;
import org.ui.swing.score.Correct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for showing 'true or false' questions
 *
 * @author Maciej
 * @version 0.2
 */
public class TorFQuestion extends JFrame implements ActionListener {
    /**
     * Object used to write log
     *
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Field that stores user's answer
     */
    private final String answer;

    /**
     * Content of the frame
     */
    private JButton trueButton;

    /**
     * Content of the frame
     */
    private JButton falseButton;

    /**
     * Content of the frame
     */
    private JButton iDonTKnowButton;

    /**
     * Content of the frame
     */
    private JLabel question;

    /**
     * Content of the frame
     */
    private JPanel panel;

    public TorFQuestion(String quest, String answer) {
        writing.writeLog(TorFQuestion.class, "Constructor()");

        // Assigns answer
        this.answer = answer;

        question.setText(quest);

        setContentPane(panel);
        setTitle("Question");
        setSize(540, 210);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        trueButton.addActionListener(this);
        falseButton.addActionListener(this);
        iDonTKnowButton.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals("I don't know")) {

            // If answer is correct lets know user and adds 1 point to the score
            writing.writeLog(getClass(), " <- Closing");
            if (e.getActionCommand().toUpperCase().equals(answer)) {
                Count.setCount(Count.getCount() + 1);
                new Correct();
            } else {
                new org.ui.swing.score.Incorrect(answer, e.getActionCommand().toUpperCase());
            }

            // Closes this window
            dispatchEvent(new WindowEvent(TorFQuestion.this, WindowEvent.WINDOW_CLOSING));

        } else {
            // Writes log and closes this window
            writing.writeLog(getClass(), " <- Closing, Don't know the answer");
            dispatchEvent(new WindowEvent(TorFQuestion.this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
