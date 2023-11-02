package org.ui.swing.admin;

import org.db.manage.ChangePassword;
import org.file.Writing;

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

    /**
     * Frame of the class
     */
    private final JFrame frame;

    /**
     * Text field for current username
     */
    private final JTextField user = new JTextField("Username");

    /**
     * Text field for new login
     */
    private final JTextField login = new JTextField("New login");

    /**
     * Text field for new password
     */
    private final JTextField password = new JTextField("New password");

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Constructor
     */
    NewPassword() {
        // Writes log
        writing.writeLog(getClass(), "New password/login");

        // Default settings
        frame = new JFrame("Changing account details");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("SUBMIT");

        // Setting bounds
        no.setBounds(325, 25, 80, 95);
        delete.setBounds(5, 90, 300, 30);

        // Adding action listeners
        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        password.setBounds(5, 55, 300, 30);
        login.setBounds(5, 25, 300, 30);
        user.setBounds(5, 5, 200, 20);

        // Adding to the frame
        frame.add(user);
        frame.add(login);
        frame.add(no);
        frame.add(delete);
        frame.add(password);


        // Setting up the visibility
        frame.setVisible(true);
    }
    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLOSE")) {
            // Writes log and closes this window
            writing.writeLog(getClass(), " <- Closing");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }else if (e.getActionCommand().equals("SUBMIT")) {
            // Writes log, changes login and password then closes this window
            writing.writeLog(getClass(), " -> ChangePassword");
            ChangePassword.change(login.getText(), password.getText(), user.getText());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
