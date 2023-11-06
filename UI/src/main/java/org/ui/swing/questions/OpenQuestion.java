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
 * Class that is responsible for showing open questions
 *
 * @author Maciej
 * @version 0.2
 */
public class OpenQuestion extends JFrame implements ActionListener {
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
    private JTextField textField1;

    /**
     * Content of the frame
     */
    private JButton submit;

    /**
     * Content of the frame
     */
    private JButton idk;

    /**
     * Content of the frame
     */
    private JLabel question;

    /**
     * Content of the frame
     */
    private JPanel panel;


    /**
     * Constructor
     */
    public OpenQuestion(String quest, String answer) {
        writing.writeLog(OpenQuestion.class, "Constructor()");

        // Assigns answer
        this.answer = answer;

        question.setText(quest);

        setContentPane(panel);
        setTitle("Question");
        setSize(540, 210);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        submit.addActionListener(this);
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
            if (textField1.getText().toUpperCase().equals(answer)) {
                Count.setCount(Count.getCount() + 1);
                new Correct();
            } else {
                new Incorrect(answer, textField1.getText().toUpperCase());
            }

            // Closes this window
            dispatchEvent(new WindowEvent(OpenQuestion.this, WindowEvent.WINDOW_CLOSING));

        } else {
            // Writes log and closes this window
            writing.writeLog(getClass(), " <- Closing, Don't know the answer");
            dispatchEvent(new WindowEvent(OpenQuestion.this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
