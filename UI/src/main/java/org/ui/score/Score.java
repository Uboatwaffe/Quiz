package org.ui.score;

import org.ui.questions.Count;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Score implements ActionListener {
    JFrame frame = new JFrame("Quiz");


    public Score(int sc){

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(190,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("CORRECT!");
        welcome.setBounds(5, 5, 150, 15);

        JLabel info = new JLabel("Your score equals: ");
        info.setBounds(5, 25, 150, 15);

        JLabel score = new JLabel(String.valueOf(sc));
        score.setBounds(5, 45, 150, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 165, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame.add(welcome);
        frame.add(info);
        frame.add(score);
        frame.add(understood);

        // Setting up the visibility
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("UNDERSTOOD")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
