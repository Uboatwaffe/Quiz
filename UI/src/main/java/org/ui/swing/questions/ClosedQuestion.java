package org.ui.swing.questions;

import org.annotation.Question;
import org.annotation.UI;
import org.file.Writing;
import org.score.Count;
import org.ui.swing.score.Correct;
import org.ui.swing.score.Incorrect;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for showing closed question
 *
 * @author Maciej
 * @version 0.2
 */
@UI
@Question
public class ClosedQuestion extends JFrame implements ActionListener {
    /**
     * Object used to write log
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
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton aButton;

    /**
     * Content of the frame
     */
    private JButton bButton;

    /**
     * Content of the frame
     */
    private JButton cButton;

    /**
     * Content of the frame
     */
    private JButton dButton;

    /**
     * Content of the frame
     */
    private JButton idk;

    /**
     * Content of the frame
     */
    private JLabel question;


    /**
     * Constructor
     * @param answer correct answer
     * @param quest question
     */
    public ClosedQuestion(String quest, String answer) {
        writing.writeLog(ClosedQuestion.class, "Constructor()");

        // Assigns answer
        this.answer = answer;

        question.setText(quest);

        setContentPane(panel);
        setTitle("Question");
        setSize(540, 210);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());

        aButton.addActionListener(this);
        bButton.addActionListener(this);
        cButton.addActionListener(this);
        dButton.addActionListener(this);
        idk.addActionListener(this);
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
            if (e.getActionCommand().equals(answer)) {
                Count.setCount(Count.getCount() + 1);
                new Correct();
            } else {
                new Incorrect(answer, e.getActionCommand());
            }

            // Closes this window
            dispatchEvent(new WindowEvent(ClosedQuestion.this, WindowEvent.WINDOW_CLOSING));

        } else {
            // Writes log and closes this window
            writing.writeLog(getClass(), " <- Closing, Don't know the answer");
            dispatchEvent(new WindowEvent(ClosedQuestion.this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
