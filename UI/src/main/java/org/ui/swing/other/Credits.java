package org.ui.swing.other;

import org.file.Writing;

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

    Writing writing = new Writing();
    public Credits() {
        writing.writeLog(Credits.class, "Constructor()");

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
                writing.writeLog(Credits.class, " <- Close");
                dispatchEvent(new WindowEvent(Credits.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}