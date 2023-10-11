package org.ui.admin;

import org.manage.SQL;
import org.ui.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TablesChange implements ActionListener {
    JFrame frame;
    String prevTable = "set1";

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

        list.addListSelectionListener(e -> prevTable = list.getSelectedValue());


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("OK");

        no.setBounds(325, 25, 80, 95);
        ok.setBounds(5, 90, 300, 30);

        no.addActionListener(this);
        ok.addActionListener(this);


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
        if (e.getActionCommand().equals("OK")){
            SQL.setCurrentTable(prevTable);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("CLOSE")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
