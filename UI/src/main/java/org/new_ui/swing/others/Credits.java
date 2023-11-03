package org.new_ui.swing.others;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Credits extends JFrame {
    private JPanel panel;
    private JButton understood;
    private JLabel CREDITS;
    private JLabel con1;
    private JLabel con2;
    private JLabel start;
    private JLabel end;
    private JLabel company;

    public Credits() {
        setContentPane(panel);
        setTitle("Credits");
        setSize(410, 230);
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
                dispatchEvent(new WindowEvent(Credits.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
