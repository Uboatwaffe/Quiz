package org.ui.questions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionABC implements ActionListener {
    String answer = null;
    public QuestionABC(String quest, String answer){
        this.answer = answer;

        // Default settings
        JFrame frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(190,170);
        frame.setLayout(null);

        // Labels
        JLabel question = new JLabel(quest);
        question.setBounds(5, 5, 150, 15);

        // Buttons
        JButton a = new JButton("A");
        JButton b = new JButton("B");
        JButton c = new JButton("C");

        a.setBounds(5, 45, 52, 70);
        b.setBounds(62, 45, 52, 70);
        c.setBounds(117, 45, 52, 70);

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);


        // Adding to the frame
        frame.add(question);
        frame.add(a);
        frame.add(b);
        frame.add(c);

        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(answer))
            System.exit(0);
    }
}
