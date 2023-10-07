package org.ui.score;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Incorrect implements ActionListener {
    JFrame frame = new JFrame("Quiz");


    public Incorrect(String answer, String wron){

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("INCORRECT!");
        welcome.setBounds(180, 5, 150, 15);

        JLabel info = new JLabel("Correct answer was: ");
        info.setBounds(5, 25, 150, 15);

        JLabel score = new JLabel(answer);
        score.setBounds(130, 25, 150, 15);

        JLabel wrong = new JLabel("You inserted: " + wron);
        wrong.setBounds(5, 45, 150, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame.add(welcome);
        frame.add(info);
        frame.add(score);
        frame.add(understood);
        frame.add(wrong);

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
