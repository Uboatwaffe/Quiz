package org.ui.others;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Credit implements ActionListener {
    // Default settings
    JFrame frame = new JFrame("Credits");

    public Credit(){
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(210,280);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("CREDITS:");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("Idea -- Maciej P.");
        string2.setBounds(5,30, 200, 15);

        JLabel string3 = new JLabel("Project structure -- Maciej P.");
        string3.setBounds(5,55, 200, 15);

        JLabel string4 = new JLabel("Start of realisation -- 07.10.2023");
        string4.setBounds(5,80, 200, 15);

        JLabel string5 = new JLabel("End of realisation -- 11.10.2023");
        string5.setBounds(5,105, 200, 15);

        JLabel string6 = new JLabel("Company -- ");
        string6.setBounds(5,130, 200, 15);

        JLabel string7 = new JLabel("VI LO im. J. i J. Śniadeckich");
        string7.setBounds(5,155, 200, 15);

        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 180, 185, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
        frame.add(string4);
        frame.add(string5);
        frame.add(string6);
        frame.add(string7);
        frame.add(understood);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
