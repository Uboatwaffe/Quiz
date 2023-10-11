package org.exceptions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExceptionUI implements ActionListener {
// Shows to user that something went wrong

    public ExceptionUI(){

        // Default settings
        JFrame frame = new JFrame("Error");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("SORRY!");
        welcome.setBounds(185, 5, 150, 15);

        JLabel info = new JLabel("Something went wrong...");
        info.setBounds(140, 25, 150, 15);

        JLabel score = new JLabel();
        score.setBounds(200, 45, 150, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

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
            System.exit(1);
        }
    }
}