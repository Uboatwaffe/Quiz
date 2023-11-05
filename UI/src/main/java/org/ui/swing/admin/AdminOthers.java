package org.ui.swing.admin;

import org.db.reset.Reset;
import org.ui.swing.admin.other.details.Details;
import org.ui.swing.admin.other.table.ChangeTable;
import org.ui.swing.admin.other.table.TablesManage;
import org.ui.swing.admin.other.tutorial.AdminTutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminOthers extends JFrame {
    private JButton tableManagement;
    private JButton tutorial;
    private JButton changeTable;
    private JButton changeDetails;
    private JButton close;
    private JButton reset;
    private JPanel panel;

    public AdminOthers() {
        setContentPane(panel);
        setTitle("AdminOthers");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        tableManagement.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new TablesManage();
                dispatchEvent(new WindowEvent(AdminOthers.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        changeTable.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangeTable();
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
                new AdminTutorial();
            }
        });
        changeDetails.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new Details();
                dispatchEvent(new WindowEvent(AdminOthers.this, WindowEvent.WINDOW_CLOSING));
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
                new AdminPanel();
                dispatchEvent(new WindowEvent(AdminOthers.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        reset.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Reset.reset();
                new AdminPanel();
                dispatchEvent((new WindowEvent(AdminOthers.this, WindowEvent.WINDOW_CLOSING)));
            }
        });
    }
}
