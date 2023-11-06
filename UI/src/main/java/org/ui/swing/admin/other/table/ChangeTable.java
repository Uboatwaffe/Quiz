package org.ui.swing.admin.other.table;

import org.db.manage.SQL;
import org.file.Writing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that is responsible for changing sets
 *
 * @author Maciej
 * @version 0.2
 */
public class ChangeTable extends JFrame {
    private final DefaultListModel<String> def;
    private final ArrayList<String> sets;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JList<String> list;

    /**
     * Content of the frame
     */
    private JButton choose;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JLabel info;

    /**
     * Content of the frame
     */
    private JButton refresh;


    private String prevTable;
    Writing writing = new Writing();
    public ChangeTable() {
        writing.writeLog(ChangeTable.class, " <- Close");

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
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(ChangeTable.class, "Set new current table");
                SQL.setCurrentTable(prevTable);
                writing.writeLog(ChangeTable.class, " <- Close");
                dispatchEvent(new WindowEvent(ChangeTable.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(ChangeTable.class, " <- Close");
                dispatchEvent(new WindowEvent(ChangeTable.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        refresh.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(ChangeTable.class, "Reloading data");
                info.setText("Current set: " + SQL.getCurrentTable());
                addData();
            }
        });
        list.addListSelectionListener(new ListSelectionListener() {
            /**
             * Called whenever the value of the selection changes.
             * @param e the event that characterizes the change.
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                writing.writeLog(ChangeTable.class, "Pre-select: " + list.getSelectedValue());
                prevTable = list.getSelectedValue();
            }
        });
    }

    /**
     * Method that adds elements to the ArrayList
     */
    private void addData() {
        sets.removeAll(sets);
        sets.addAll(Arrays.asList(SQL.getAllTables()));
        refreshData();
    }

    /**
     * Method that refreshes content of JList
     */
    private void refreshData() {
        def.removeAllElements();
        for (String x : sets) {
            def.addElement(x);
        }
    }
}
