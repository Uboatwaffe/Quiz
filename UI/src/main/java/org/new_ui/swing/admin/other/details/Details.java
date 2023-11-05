package org.new_ui.swing.admin.other.details;

import org.db.connecting.LoggingIn;
import org.db.manage.ChangePassword;
import org.new_ui.swing.admin.AdminOthers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Details extends JFrame {
    private JTextField newLogin;
    private JTextField newPassword;
    private JButton submit;
    private JButton close;
    private JLabel info;
    private JPanel panel;

    public Details() {
        setContentPane(panel);
        setTitle("Change details");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        submit.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePassword.change(newLogin.getText(), newPassword.getText(), LoggingIn.getLoginAndPassword()[2]);
                dispatchEvent(new WindowEvent(Details.this, WindowEvent.WINDOW_CLOSING));
                new AdminOthers();
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
                new AdminOthers();
                dispatchEvent(new WindowEvent(Details.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
