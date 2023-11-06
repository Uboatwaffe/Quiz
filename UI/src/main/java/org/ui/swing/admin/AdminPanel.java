package org.ui.swing.admin;

import org.file.Writing;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminPanel extends JFrame {

    /**
     * Content of the frame
     */
    private JButton add;

    /**
     * Content of the frame
     */
    private JButton delete;

    /**
     * Content of the frame
     */
    private JButton show_q;

    /**
     * Content of the frame
     */
    private JButton show_a;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JButton others;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JLabel welcome;

    /**
     * Content of the frame
     */
    private JLabel what_to_do;

    Writing writing = new Writing();
    public AdminPanel() {
        writing.writeLog(AdminPanel.class, "Constructor()");

        setContentPane(panel);
        setTitle("Admin panel");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        add.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminPanel.class, " -> AddQ");
                new AddQ();
            }
        });
        delete.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminPanel.class, " -> DeleteQ");
                new DeleteQ();
            }
        });
        show_q.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminPanel.class, " -> ShowQ");
                new ShowQ();
            }
        });
        show_a.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminPanel.class, " -> ShowA");
                new ShowA();
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminPanel.class, " -> MainSwing");
                new MainSwing();
                writing.writeLog(AdminPanel.class, " <- Close");
                dispatchEvent(new WindowEvent(AdminPanel.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        others.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminPanel.class, " -> AdminOthers");
                new AdminOthers();
                writing.writeLog(AdminPanel.class, " <- Close");
                dispatchEvent(new WindowEvent(AdminPanel.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
