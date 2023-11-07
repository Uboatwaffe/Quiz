package org.ui.swing.exceptions;

import org.ui.swing.MainSwing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * @author
 */
public class WrongPassword extends JFrame {
    private JPanel panel;
    private JButton understoodButton;
    private JLabel info;
    private JLabel why;

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
