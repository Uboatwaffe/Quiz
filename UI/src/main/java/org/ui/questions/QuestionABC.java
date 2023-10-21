package org.ui.questions;

import org.file.writing.Writing;
import org.ui.score.Incorrect;
import org.ui.score.Score;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing close question
 * @author Maciej
 * @version 0.1
 */
public class QuestionABC implements ActionListener {
    // UI for showing close question
    private final JFrame frame = new JFrame("Quiz");
    private final String answer;
    private final static Writing writing = new Writing();

    /**
     * Constructor
     */
    public QuestionABC(String quest, String answer) {
        writing.writeLog(getClass(),"Closed question");

        this.answer = answer;

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,200);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 400, 15);

        // Buttons
        JButton a = new JButton("A");
        JButton b = new JButton("B");
        JButton c = new JButton("C");
        JButton d = new JButton("D");
        JButton no = new JButton("I DO NOT KNOW");

        a.setBounds(5, 45, 100, 70);
        b.setBounds(110, 45, 100, 70);
        c.setBounds(215, 45, 100, 70);
        d.setBounds(320, 45, 100, 70);
        no.setBounds(5, 120, 415, 35);


        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        no.addActionListener(this);


        // Adding to the frame
        frame.add(question);
        frame.add(a);
        frame.add(b);
        frame.add(c);
        frame.add(d);
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
