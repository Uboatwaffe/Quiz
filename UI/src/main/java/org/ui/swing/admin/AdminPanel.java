package org.ui.swing.admin;

import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminPanel extends JFrame {
    private JButton add;
    private JButton delete;
    private JButton show_q;
    private JButton show_a;
    private JButton close;
    private JButton others;
    private JPanel panel;
    private JLabel welcome;
    private JLabel what_to_do;

    public AdminPanel() {
        setContentPane(panel);
        setTitle("AdminPanel");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        add.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddQ();
            }
        });
        delete.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteQ();
            }
        });
        show_q.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowQ();
            }
        });
        show_a.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowA();
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
                new MainSwing();
                dispatchEvent(new WindowEvent(AdminPanel.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        others.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminOthers();
                dispatchEvent(new WindowEvent(AdminPanel.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
