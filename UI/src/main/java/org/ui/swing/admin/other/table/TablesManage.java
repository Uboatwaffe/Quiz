package org.ui.swing.admin.other.table;

import org.ui.swing.admin.AdminOthers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TablesManage extends JFrame {
    private JButton addTable;
    private JButton deleteTable;
    private JButton close;
    private JPanel panel;
    private JLabel what_to_do;

    public TablesManage() {
        setContentPane(panel);
        setTitle("Table management");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        addTable.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddTable();
            }
        });
        deleteTable.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteTable();
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
                dispatchEvent(new WindowEvent(TablesManage.this, WindowEvent.WINDOW_CLOSING));
                new AdminOthers();
            }
        });
    }
}
