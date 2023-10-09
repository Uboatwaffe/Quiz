package org.ui.admin;

import org.manage.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablesChange implements ActionListener {
    JFrame frame;

    public TablesChange() {
        frame = new JFrame("Changing table");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Current table: " + SQL.getCurrentTable());
        welcome.setBounds(5, 5, 200, 15);

        JList<String> list = new JList<>(SQL.getAllTables());
        JScrollPane pane = new JScrollPane(list);

        pane.setBounds(5, 25, 300, 60);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("OK");

        no.setBounds(325, 25, 80, 95);
        ok.setBounds(5, 90, 300, 30);

        no.addActionListener(this);
        ok.addActionListener(this);

        // Text-field

        // Adding to the frame
        frame.add(welcome);
        frame.add(pane);
        frame.add(no);
        frame.add(ok);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
