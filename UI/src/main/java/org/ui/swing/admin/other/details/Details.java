package org.ui.swing.admin.other.details;

import org.db.connecting.LoggingIn;
import org.db.manage.ChangePassword;
import org.file.Writing;
import org.ui.swing.admin.AdminOthers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for allowing user to change password/login
 *
 * @author Maciej
 * @version 0.2
 */
public class Details extends JFrame {
    /**
     * Content of the frame
     */
    private JTextField newLogin;
    /**
     * Content of the frame
     */
    private JTextField newPassword;
    /**
     * Content of the frame
     */
    private JButton submit;
    /**
     * Content of the frame
     */
    private JButton close;
    /**
     * Content of the frame
     */
    private JLabel info;
    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
    public Details() {
        writing.writeLog(Details.class, " <- Close");

        setContentPane(panel);
        setTitle("Change details");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        submit.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Details.class, "Set new password and login");
                ChangePassword.change(newLogin.getText(), newPassword.getText(), LoggingIn.getLoginAndPassword()[2]);
                writing.writeLog(Details.class, " <- Close");
                dispatchEvent(new WindowEvent(Details.this, WindowEvent.WINDOW_CLOSING));
                writing.writeLog(Details.class, " -> AdminOthers");
                new AdminOthers();
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Details.class, " -> AdminOthers");
                new AdminOthers();
                writing.writeLog(Details.class, " <- Close");
                dispatchEvent(new WindowEvent(Details.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
