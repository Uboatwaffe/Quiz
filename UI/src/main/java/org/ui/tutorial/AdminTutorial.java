package org.ui.tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminTutorial implements ActionListener {
    // Default settings
    JFrame frame = new JFrame("Tutorial");

    public AdminTutorial(){
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(310,285);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("Welcome to the tutorial!");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("There are 3 types of data input:");
        string2.setBounds(5,30, 200, 15);

        JLabel string3 = new JLabel("1) Closed type is 'c', required answer is A/B/C/D");
        string3.setBounds(5,55, 400, 15);

        JLabel string4 = new JLabel("2) Date type is 'd', required answer is DD.MM.YYYY");
        string4.setBounds(5,80, 400, 15);

        JLabel string5 = new JLabel("3) Open question type is 'o', required answer is");
        string5.setBounds(5,105, 400, 15);

        JLabel string6 = new JLabel("typed with CAPS LOCK");
        string6.setBounds(5,130, 400, 15);

        JLabel string7 = new JLabel("4) True or false type is 't', required answer is");
        string7.setBounds(5,150, 400, 15);

        JLabel string8 = new JLabel("TRUE/FALSE");
        string8.setBounds(5,170, 400, 15);

        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 190, 285, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
        frame.add(string4);
        frame.add(string5);
        frame.add(string6);
        frame.add(string7);
        frame.add(string8);
        frame.add(understood);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
