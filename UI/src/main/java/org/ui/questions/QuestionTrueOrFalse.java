package org.ui.questions;

import org.file.writing.Writing;
import org.ui.score.Incorrect;
import org.ui.score.Score;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing true or false log.txt
 * @author Maciej
 * @version 0.1
 */
public class QuestionTrueOrFalse implements ActionListener {
    // UI for showing true or false question
    private final JFrame frame = new JFrame("Quiz");
    private final String answer;
    private final static Writing writing = new Writing();

    /**
     * Constructor
     * @param quest String with question
     * @param answer String with expected answer
     */
    public QuestionTrueOrFalse(String quest, String answer) {
        writing.writeLog(getClass(),"True or false question");

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


        t.setBounds(5, 45, 200, 70);
        f.setBounds(210, 45, 200, 70);
        no.setBounds(5, 120, 405, 35);



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
            try {
                if (e.getActionCommand().equals(answer)) {
                    Count.setCount(Count.getCount() + 1);
                    new Score(Count.getCount());
                } else {
                    new Incorrect(answer, e.getActionCommand());
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
