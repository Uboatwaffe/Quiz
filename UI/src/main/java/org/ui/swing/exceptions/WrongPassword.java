package org.ui.swing.exceptions;

import org.ui.swing.MainSwing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI that shows to the user that given login/password is incorrect
 * @version 0.1
 * @author Maciej
 */
public class WrongPassword extends JFrame {

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton understoodButton;

    /**
     * Content of the frame
     */
    private JLabel info;

    /**
     * Content of the frame
     */
    private JLabel why;


    /**
     * Constructor
     */
    public WrongPassword() {
        setContentPane(panel);
        setTitle("Wrong password");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        understoodButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(WrongPassword.this, WindowEvent.WINDOW_CLOSING));
                new MainSwing();
            }
        });
    }
}
