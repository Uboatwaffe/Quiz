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

/**
 * Class that is responsible for showing more options for admin
 *
 * @author Maciej
 * @version 0.2
 */
public class AdminOthers extends JFrame {

    /**
     * Content of the frame
     */
    private JButton tableManagement;

    /**
     * Content of the frame
     */
    private JButton tutorial;

    /**
     * Content of the frame
     */
    private JButton changeTable;

    /**
     * Content of the frame
     */
    private JButton changeDetails;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JButton reset;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
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
