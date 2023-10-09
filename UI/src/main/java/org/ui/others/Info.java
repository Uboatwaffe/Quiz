package org.ui.others;

import org.manage.HowMany;
import org.manage.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Info implements ActionListener {
    // Default settings
    JFrame frame = new JFrame("Info");
    HowMany howMany = new HowMany();

    public Info(){
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(210,200);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("Info:");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("Current set: " + SQL.getCurrentTable());
        string2.setBounds(5,30, 200, 15);

        JLabel string3 = new JLabel("Number of questions: " + howMany.howMany());
        string3.setBounds(5,55, 200, 15);

        JLabel string4 = new JLabel("Points: ");
        string4.setBounds(5,80, 200, 15);


        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5,105, 185, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
        frame.add(string4);
        frame.add(understood);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}