package org.new_ui.swing.admin;

import org.db.manage.Sorting;
import org.db.manage.ToStrings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ShowA extends JFrame {
    private final DefaultListModel<String> def;
    private final ArrayList<String> sets;
    private JList<String> list;
    private JPanel panel;
    private JButton refresh;
    private JButton close;
    private final ToStrings toStrings = new ToStrings();

    public ShowA() {
        setContentPane(panel);
        setTitle("All answers");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        sets = new ArrayList<>();
        def = new DefaultListModel<>();
        list.setModel(def);

        addData();
        refresh.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Sorting sorting = new Sorting();
                sorting.sort();
                addData();
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
                dispatchEvent(new WindowEvent(ShowA.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

    private void addData() {
        sets.removeAll(sets);
        sets.addAll(Arrays.asList(toStrings.answersInStringArray()));
        refreshData();
    }

    private void refreshData() {
        def.removeAllElements();
        for (String x : sets) {
            def.addElement(x);
        }
    }
}

