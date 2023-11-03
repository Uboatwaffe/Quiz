package org.new_ui.swing;

import org.new_ui.swing.tutorial.Tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwing extends JFrame {
    private JPanel panel;
    private JButton tutorial;
    private JButton adminPanel;
    private JButton start;
    private JButton info;
    private JButton close;
    private JButton credits;
    private JLabel welocme;
    private JLabel what_to_do;

    public MainSwing() {
        setContentPane(panel);
        setTitle("QuizSwing");
        setSize(440, 170);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        start.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

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

            }
        });
        info.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        credits.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tutorial.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tutorial();
            }
        });
        adminPanel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
