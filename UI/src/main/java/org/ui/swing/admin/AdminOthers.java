package org.ui.swing.admin;

import org.db.reset.Reset;
import org.file.Writing;
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

    Writing writing = new Writing();
    public AdminOthers() {
        writing.writeLog(AdminOthers.class, "Constructor()");

        setContentPane(panel);
        setTitle("Admin others");
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
                writing.writeLog(AdminOthers.class, " -> TablesManage");
                new TablesManage();
                writing.writeLog(AdminOthers.class, " <- Close");
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
                writing.writeLog(AdminOthers.class, " -> ChangeTable");
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
                writing.writeLog(AdminOthers.class, " -> AdminTutorial");
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
                writing.writeLog(AdminOthers.class, " -> Details");
                new Details();
                writing.writeLog(AdminOthers.class, " <- Close");
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
                writing.writeLog(AdminOthers.class, " -> AdminPanel");
                new AdminPanel();
                writing.writeLog(AdminOthers.class, " <- Close");
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
                writing.writeLog(AdminOthers.class, " -> Reset");
                Reset.reset();
                writing.writeLog(AdminOthers.class, " -> AdminPanel");
                new AdminPanel();
                writing.writeLog(AdminOthers.class, " <- Close");
                dispatchEvent((new WindowEvent(AdminOthers.this, WindowEvent.WINDOW_CLOSING)));
            }
        });
    }
}
