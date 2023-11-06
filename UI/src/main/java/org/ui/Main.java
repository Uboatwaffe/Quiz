package org.ui;

import org.exceptions.file.ERRORS;
import org.file.Writing;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    static Writing writing = new Writing();

    static ERRORS errors2 = new ERRORS();
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
        writing.writeLog(Main.class, "Constructor()");

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
                writing.writeLog(Main.class, " -> MainSwing");
                new MainSwing();
                writing.writeLog(Main.class, "Hide");
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
                writing.writeLog(Main.class, " -> Website");
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
        writing.clear();
        errors2.clear();
        writing.writeLog(Main.class, "Starting program");
        new Main();
    }

    public void showMain() {
        writing.writeLog(Main.class, "Showing main");
        setVisible(true);
    }
}
