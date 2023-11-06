package org.ui.swing.admin.other.table;

import org.file.Writing;
import org.ui.swing.admin.AdminOthers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for accessing files that add and delete tables in the DB
 *
 * @author Maciej
 * @version 0.2
 */
public class TablesManage extends JFrame {

    /**
     * Content of the frame
     */
    private JButton addTable;

    /**
     * Content of the frame
     */
    private JButton deleteTable;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JLabel what_to_do;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    Writing writing = new Writing();

    /**
     * Constructor
     */
    public TablesManage() {
        writing.writeLog(TablesManage.class, "Constructor()");

        setContentPane(panel);
        setTitle("Table management");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        addTable.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(TablesManage.class, " -> AddTable");
                new AddTable();
            }
        });
        deleteTable.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(TablesManage.class, " -> DeleteTable");
                new DeleteTable();
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(TablesManage.class, " <- Close");
                dispatchEvent(new WindowEvent(TablesManage.this, WindowEvent.WINDOW_CLOSING));
                writing.writeLog(TablesManage.class, " -> AdminOthers");
                new AdminOthers();
            }
        });
    }
}
