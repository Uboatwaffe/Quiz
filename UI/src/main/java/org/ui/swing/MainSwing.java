package org.ui.swing;

import org.file.Writing;
import org.ui.Main;
import org.ui.swing.hq.HQ;
import org.ui.swing.tutorial.Tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainSwing extends JFrame {

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton tutorial;

    /**
     * Content of the frame
     */
    private JButton adminPanel;

    /**
     * Content of the frame
     */
    private JButton start;

    /**
     * Content of the frame
     */
    private JButton info;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JButton credits;

    /**
     * Content of the frame
     */
    private JLabel welocme;

    /**
     * Content of the frame
     */
    private JLabel what_to_do;

    Writing writing = new Writing();
    public MainSwing() {
        writing.writeLog(MainSwing.class, "Constructor()");

        setContentPane(panel);
        setTitle("QuizSwing");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        start.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(MainSwing.class, " -> HQ");
                HQ hq = new HQ();
                hq.start();
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(MainSwing.class, " -> Main");
                Main main = new org.ui.Main();
                main.showMain();
                dispatchEvent(new WindowEvent(MainSwing.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        info.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(MainSwing.class, " -> Info");
                new org.ui.swing.other.Info();
            }
        });
        credits.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(MainSwing.class, " -> Credits");
                new org.ui.swing.other.Credits();
            }
        });
        tutorial.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(MainSwing.class, " -> Tutorial");
                new Tutorial();
            }
        });
        adminPanel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(MainSwing.class, " -> Logging_In");
                new org.ui.swing.admin.Logging_In();
                dispatchEvent(new WindowEvent(MainSwing.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
