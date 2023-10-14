package org.ui.questions;

import org.ui.score.Incorrect;
import org.ui.score.Score;
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
    // UI for showing open question
    private final String answer;
    private final JFrame frame = new JFrame("Quiz");
    private final JTextField field = new JTextField("This is an open question", 10);
    public QuestionOpen(String quest, String answer){
        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 400, 15);

        // Button
        JButton submit = new JButton("SUBMIT");

        submit.setBounds(5, 65, 415, 60);

        submit.addActionListener(this);

        // Text-field
        field.setBounds(5, 25, 415, 30);

        // Adding to the frame
        frame.add(question);
        frame.add(field);
        frame.add(submit);

        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SUBMIT")) {
            if (field.getText().equals(answer)) {
                Count.setCount(Count.getCount()+1);
                new Score(Count.getCount());
            }else
                new Incorrect(answer, field.getText());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
