package org.ui.admin;

import org.db.connecting.LoggingIn;
import org.file.writing.Writing;
import org.ui.Main;
import org.ui.admin.others.WrongPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing logging in
 * @author Maciej
 * @version 0.1
 */
public class Logging implements ActionListener {

    /**
     * Frame of the class
     */
    private final JFrame frame;

    /**
     * Text field for login
     */
    private final JTextField login = new JTextField("Login");

    /**
     * Text field for password
     */
    private final JTextField password = new JTextField("Password");

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Constructor
     */
    public Logging() {
        // Writing log
        writing.writeLog(getClass(), "Logging in");

        // Default settings
        frame = new JFrame("Logging in");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Please log in: ");
        welcome.setBounds(5, 5, 200, 15);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("LOG IN");

        // Setting bounds
        no.setBounds(325, 25, 80, 95);
        delete.setBounds(5, 90, 300, 30);

        // Adding action listeners
        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        password.setBounds(5, 55, 300, 30);
        login.setBounds(5, 25, 300, 30);

        // Adding to the frame
        frame.add(welcome);
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
        if (e.getActionCommand().equals("LOG IN")) {
            if (!login.getText().equals(LoggingIn.getLoginAndPassword()[0]) && password.getText().equals(LoggingIn.getLoginAndPassword()[1])) {
                // Writing log
                writing.writeLog(getClass(), "Goto wrong password");

                // Going to WrongPassword() and closing this window
                new WrongPassword();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            } else {
                // Writing log
                writing.writeLog(getClass(), "Goto admin panel");

                // Going to AdminPanel() and closing this window
                new AdminPanel();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        } else {
            // Writing log
            writing.writeLog(getClass(), "Closing");

            // Showing main menu
            Main main = new Main();
            main.showMain();

            // Closing this window
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
