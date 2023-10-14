package org.ui.admin;

import org.manage.ChangePassword;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for changing password/login
 * @author Maciej
 * @version 0.1
 */
class NewPassword implements ActionListener {
    // UI for changing your password/login
    private final JFrame frame;
    private final JTextField user = new JTextField("Username");
    private final JTextField login = new JTextField("New login");
    private final JTextField password = new JTextField("New password");

    NewPassword() {
        frame = new JFrame("Changing account details");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        user.setBounds(5, 5, 200, 20);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("SUBMIT");

        no.setBounds(325, 25, 80, 95);
        delete.setBounds(5, 90, 300, 30);

        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        password.setBounds(5, 55, 300, 30);
        login.setBounds(5, 25, 300, 30);

        // Adding to the frame
        frame.add(user);
        frame.add(login);
        frame.add(no);
        frame.add(delete);
        frame.add(password);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CLOSE"))
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        else if (e.getActionCommand().equals("SUBMIT")) {
            ChangePassword.change(login.getText(),password.getText(),user.getText());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
