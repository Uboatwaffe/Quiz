package org.ui.questions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import org.ui.score.Incorrect;
import org.ui.score.Score;


public class QuestionDate implements ActionListener {

    private final String answer;
    private final JFrame frame = new JFrame("Quiz");
    private final JTextField field = new JTextField("This is question about date", 100);
    public QuestionDate(String quest, String answer){
        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 150, 15);

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
            if (field.getText().equals(this.answer)) {
                new Score(++Count.count);
            }else
                new Incorrect(answer, field.getText());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
