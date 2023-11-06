package org.ui.swing.admin;

import org.db.connecting.LoggingIn;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for checking if password and login are correct
 *
 * @author Maciej
 * @version 0.2
 */
public class Logging_In extends JFrame {

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JTextField login;

    /**
     * Content of the frame
     */
    private JPasswordField password;

    /**
     * Content of the frame
     */
    private JButton log_in;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JLabel insert_login;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    Writing writing = new Writing();

    /**
     * Constructor
     */
    public Logging_In() {
        writing.writeLog(Logging_In.class, "Constructor()");

        setContentPane(panel);
        setTitle("Log in");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        log_in.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login.getText().equals(LoggingIn.getLoginAndPassword()[0]) && password.getText().equals(LoggingIn.getLoginAndPassword()[1])) {
                    writing.writeLog(Logging_In.class, "Logged successfully");
                    writing.writeLog(Logging_In.class, " -> AdminPanel");
                    new AdminPanel();
                    writing.writeLog(Logging_In.class, " <- Close");
                    dispatchEvent(new WindowEvent(Logging_In.this, WindowEvent.WINDOW_CLOSING));
                } else {
                    writing.writeLog(Logging_In.class, "Logging in was unsuccessful");
                    // TODO this
                }
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Logging_In.class, " <- Close");
                dispatchEvent(new WindowEvent(Logging_In.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
