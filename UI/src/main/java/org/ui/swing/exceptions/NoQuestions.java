package org.ui.swing.exceptions;

import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * @author
 */
public class NoQuestions extends JFrame {
    private JPanel panel;
    private JButton close;
    private JLabel info;
    private JLabel why;

    public NoQuestions() {
        setContentPane(panel);
        setTitle("No questions");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(NoQuestions.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
