package org.ui.admin;

import org.db.reset.Reset;
import org.exceptions.ExceptionUI;
import org.ui.tutorial.AdminTutorial;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * UI for showing other options of admin panel
 * @author Maciej
 * @version 0.1
 */
public class AdminOther implements ActionListener {
    // Second menu for AdminPanel
    private final JFrame frame = new JFrame("Other");
    public AdminOther() {
        frame.setSize(440, 170);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(null);

        // Buttons
        JButton tutorial = new JButton("TUTORIAL");
        JButton changePassword = new JButton("DETAILS");
        JButton close = new JButton("CLOSE");
        JButton reset = new JButton("RESET");
        JButton addT = new JButton("TABLE MANAGEMENT");
        JButton changeTable = new JButton("CHANGE TABLE");

        tutorial.setBounds(180, 5, 150, 55);
        changePassword.setBounds(180, 65, 150, 55);
        close.setBounds(335, 5, 80, 55);
        reset.setBounds(335, 65, 80, 55);
        addT.setBounds(5, 5, 170, 55);
        changeTable.setBounds(5, 65, 170, 55);

        tutorial.addActionListener(this);
        changePassword.addActionListener(this);
        changeTable.addActionListener(this);
        close.addActionListener(this);
        addT.addActionListener(this);
        reset.addActionListener(this);

        // Adding to the frame
        frame.add(addT);
        frame.add(close);
        frame.add(tutorial);
        frame.add(changePassword);
        frame.add(changeTable);
        frame.add(reset);

        // Setting up the visibility
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLOSE")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("TUTORIAL")) {
            try {
                new AdminTutorial();
            } catch (IOException ignore) {
                new ExceptionUI();
            }
        } else if (e.getActionCommand().equals("DETAILS")) {
            new NewPassword();
        }else if (e.getActionCommand().equals("CHANGE TABLE")) {
            new TablesChange();
        } else if (e.getActionCommand().equals("TABLE MANAGEMENT")) {
            new TablesManage();
        } else if (e.getActionCommand().equals("RESET")) {
            Reset.reset();
            frame.dispatchEvent((new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
        }
    }
}
