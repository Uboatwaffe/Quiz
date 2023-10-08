package org.ui.others;

import org.ui.Main;
import org.ui.tutorial.AdminTutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminOther implements ActionListener {
    JFrame frame = new JFrame("Other");


    public AdminOther() {
        frame.setSize(440, 170);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(null);

        // Buttons
        JButton tutorial = new JButton("TUTORIAL");
        JButton changePassword = new JButton("CHANGE PASSWORD");
        JButton close = new JButton("CLOSE");
        JButton addT = new JButton("ADD TABLE");
        JButton changeTable = new JButton("CHANGE TABLE");

        tutorial.setBounds(180, 5, 150, 55);
        changePassword.setBounds(180, 65, 235, 55);
        close.setBounds(335, 5, 80, 55);
        addT.setBounds(5, 5, 170, 55);
        changeTable.setBounds(5, 65, 170, 55);

        tutorial.addActionListener(this);
        changePassword.addActionListener(this);
        changeTable.addActionListener(this);
        close.addActionListener(this);
        addT.addActionListener(this);


        // Adding to the frame
        frame.add(addT);
        frame.add(close);
        frame.add(tutorial);
        frame.add(changePassword);
        frame.add(changeTable);

        // Setting up the visibility
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLOSE")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("TUTORIAL")) {
            new AdminTutorial();
        } else if (e.getActionCommand().equals("CHANGE PASSWORD")) {
            new NewPassword();
        }
    }
}
