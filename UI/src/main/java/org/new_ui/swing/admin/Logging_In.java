package org.new_ui.swing.admin;

import org.db.connecting.LoggingIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Logging_In extends JFrame {
    private JPanel panel;
    private JTextField login;
    private JPasswordField password;
    private JButton log_in;
    private JButton close;
    private JLabel please;
    private JLabel insert_login;
    private JLabel insert_password;

    public Logging_In() {
        setContentPane(panel);
        setTitle("Log in");
        setSize(400, 200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        log_in.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login.getText().equals(LoggingIn.getLoginAndPassword()[0]) && password.getText().equals(LoggingIn.getLoginAndPassword()[1])) {
                    System.exit(0);
                }
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(Logging_In.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
