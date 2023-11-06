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

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton swing;

    /**
     * Content of the frame
     */
    private JButton website;

    /**
     * Content of the frame
     */
    private JButton quit;

    /**
     * Content of the frame
     */
    private JLabel welcome;

    /**
     * Content of the frame
     */
    private JLabel types;

    /**
     * Content of the frame
     */
    private JLabel GUI;

    /**
     * Content of the frame
     */
    private JLabel web;

    /**
     * Content of the frame
     */
    private JLabel errors;

    /**
     * Content of the frame
     */
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
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Main.class, " <- EXIT");
                System.exit(0);
            }
        });
    }

    /**
     * Method that starts whole program
     *
     * @param args argument required to launching program
     */
    public static void main(String[] args) {
        writing.clear();
        errors2.clear();
        writing.writeLog(Main.class, "Starting program");
        new Main();
    }

    /**
     * Method that shows content of this class to user
     */
    public void showMain() {
        writing.writeLog(Main.class, "Showing main");
        setVisible(true);
    }
}
