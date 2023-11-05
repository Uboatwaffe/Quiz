package org.new_ui.swing.questions;

import org.file.Writing;
import org.new_ui.swing.score.Correct;
import org.new_ui.swing.score.Incorrect;
import org.score.Count;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ClosedQuestion extends JFrame implements ActionListener {
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
    private JPanel panel;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton idk;
    private JLabel question;

    public ClosedQuestion(String quest, String answer) {
        // Assigns answer
        this.answer = answer;

        question.setText(quest);

        setContentPane(panel);
        setTitle("Question");
        setSize(540, 210);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        aButton.addActionListener(this);
        bButton.addActionListener(this);
        cButton.addActionListener(this);
        dButton.addActionListener(this);
        idk.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
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
