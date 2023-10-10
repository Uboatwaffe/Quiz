package org.ui.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TablesManage implements ActionListener {
    JFrame frame;

    public TablesManage() {
        frame = new JFrame("What to do");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("What do you want to do?");
        welcome.setBounds(5, 5, 200, 15);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton addTable = new JButton("ADD TABLE");
        JButton deleteTable = new JButton("DELETE TABLE");


        no.setBounds(325, 25, 80, 95);
        addTable.setBounds(5, 25, 300, 45);
        deleteTable.setBounds(5, 75, 300, 45);

        no.addActionListener(this);
        addTable.addActionListener(this);
        deleteTable.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(no);
        frame.add(addTable);
        frame.add(deleteTable);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLOSE")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("ADD TABLE")) {
            new TableAdd();
        } else if (e.getActionCommand().equals("DELETE TABLE")) {
            
        }
    }
}
