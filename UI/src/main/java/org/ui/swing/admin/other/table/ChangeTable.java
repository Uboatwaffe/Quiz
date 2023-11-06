package org.ui.swing.admin.other.table;

import org.db.manage.SQL;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ChangeTable extends JFrame {
    private final DefaultListModel<String> def;
    private final ArrayList<String> sets;
    private JPanel panel;
    private JList<String> list;
    private JButton choose;
    private JButton close;
    private JLabel info;
    private JButton refresh;
    private String prevTable;

    public ChangeTable() {
        setContentPane(panel);
        setTitle("Changing of the table");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        info.setText("Current set: " + SQL.getCurrentTable());

        sets = new ArrayList<>();
        def = new DefaultListModel<>();
        list.setModel(def);

        addData();

        choose.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                SQL.setCurrentTable(prevTable);
                dispatchEvent(new WindowEvent(ChangeTable.this, WindowEvent.WINDOW_CLOSING));
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
                dispatchEvent(new WindowEvent(ChangeTable.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        refresh.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                info.setText("Current set: " + SQL.getCurrentTable());
                addData();
            }
        });
        list.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             *
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                prevTable = list.getSelectedValue();
            }
        });
    }

    private void addData() {
        sets.removeAll(sets);
        sets.addAll(Arrays.asList(SQL.getAllTables()));
        refreshData();
    }

    private void refreshData() {
        def.removeAllElements();
        for (String x : sets) {
            def.addElement(x);
        }
    }
}
