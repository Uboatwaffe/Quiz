package org.ui;

import org.file.Writing;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Writing writing = new Writing();

    private JPanel panel;
    private JButton swing;
    private JButton website;
    private JButton quit;
    private JLabel welcome;
    private JLabel types;
    private JLabel GUI;
    private JLabel web;
    private JLabel errors;
    private JLabel fun;

    public Main() {
        setContentPane(panel);
        setTitle("Quiz");
        setSize(530, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        swing.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainSwing();
                setVisible(false);
            }
        });
        website.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        quit.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Main.class, " <- EXIT");
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }

    public void showMain() {
        setVisible(true);
    }
}
