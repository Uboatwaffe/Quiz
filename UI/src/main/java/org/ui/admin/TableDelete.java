package org.ui.admin;

import org.manage.SQL;
import org.tables.Add;
import org.tables.Delete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TableDelete implements ActionListener {

    private final JFrame frame;
    private final JTextField login = new JTextField("Name of the table");
    private final JLabel error = new JLabel("There is no such table or it can't be deleted!");

    public TableDelete() {
        frame = new JFrame("Deleting table");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Insert name of the table: ");
        welcome.setBounds(5, 5, 200, 15);

        error.setBounds(5, 25, 300, 15);
        error.setVisible(false);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("DELETE");

        no.setBounds(325, 25, 80, 95);
        ok.setBounds(5, 85, 300, 35);

        no.addActionListener(this);
        ok.addActionListener(this);

        // Text-field
        login.setBounds(5, 45, 300, 30);

        // Adding to the frame
        frame.add(welcome);
        frame.add(error);
        frame.add(login);
        frame.add(no);
        frame.add(ok);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLOSE")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("DELETE")) {
            String[] db = SQL.getAllTables();
            String newName = login.getText();
            boolean exists = false;
            for (int i = 0; i < db.length; i++) {
                if (newName.equals(db[i]) && !newName.equals("set1")) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                error.setVisible(false);
                Delete.delete(newName);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            } else {
                error.setVisible(true);
            }
        }
    }
}


