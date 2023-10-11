package org.ui.admin;

import org.manage.SQL;
import org.tables.Add;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TableAdd implements ActionListener {
    private final JFrame frame;
    private final JTextField login = new JTextField("New name");
    private final JLabel error = new JLabel("This name is already taken!");

    public TableAdd() {
        frame = new JFrame("Adding table");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Insert new name for the table: ");
        welcome.setBounds(5, 5, 200, 15);

        error.setBounds(5, 25, 200, 15);
        error.setVisible(false);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("OK");

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
        if(e.getActionCommand().equals("CLOSE")){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("OK")) {
            String[] db = SQL.getAllTables();
            String newName = login.getText();
            boolean exists = false;
            for (int i = 0; i < db.length; i++) {
                if (newName.equals(db[i])){
                    exists = true;
                    break;
                }
            }
            if (!exists){
                error.setVisible(false);
                Add.add(newName);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }else {
                error.setVisible(true);
            }
        }
    }
}
