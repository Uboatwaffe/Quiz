package org.ui.questions;

import org.ui.score.Incorrect;
import org.ui.score.Score;
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
    // UI for showing true or false question
    private final JFrame frame = new JFrame("Quiz");
    private final String answer;
    public QuestionTrueOrFalse(String quest, String answer){
        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 400, 15);

        // Buttons
        JButton t = new JButton("TRUE");
        JButton f = new JButton("FALSE");


        t.setBounds(5, 45, 200, 70);
        f.setBounds(210, 45, 200, 70);



        t.addActionListener(this);
        f.addActionListener(this);



        // Adding to the frame
        frame.add(question);
        frame.add(t);
        frame.add(f);

        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(answer)) {
            Count.setCount(Count.getCount()+1);
            new Score(Count.getCount());
        }else
            new Incorrect(answer, e.getActionCommand());
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
