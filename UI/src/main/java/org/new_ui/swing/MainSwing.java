package org.new_ui.swing;

import org.new_ui.Main;
import org.new_ui.swing.hq.HQ;
import org.new_ui.swing.tutorial.Tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        start.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                HQ hq = new HQ();
                hq.start();
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
                Main main = new org.new_ui.Main();
                main.showMain();
                dispatchEvent(new WindowEvent(MainSwing.this, WindowEvent.WINDOW_CLOSING));
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
                new org.new_ui.swing.other.Info();
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
                new org.new_ui.swing.other.Credits();
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
                new org.new_ui.swing.admin.Logging_In();
                dispatchEvent(new WindowEvent(MainSwing.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
