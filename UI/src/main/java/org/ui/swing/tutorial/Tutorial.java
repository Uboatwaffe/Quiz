package org.ui.swing.tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Tutorial extends JFrame {
    private JButton understood;
    private JLabel welocme;
    private JLabel types;
    private JLabel closed;
    private JLabel true_or_false;
    private JLabel date;
    private JLabel open;
    private JPanel panel;

    public Tutorial() {
        setContentPane(panel);
        setTitle("Tutorial");
        setSize(440, 230);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        understood.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(Tutorial.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
