package org.new_ui.swing.admin.other.table;

import org.db.manage.SQL;
import org.db.tables.Add;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class AddTable extends JFrame {
    private final Writing writing = new Writing();
    private JButton close;
    private JLabel info;
    private JLabel error;
    private JButton create;
    private JPanel panel;
    private JTextField name;

    AddTable() {
        setContentPane(panel);
        setTitle("Adding table");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        error.setVisible(false);

        setVisible(true);
        create.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] db = SQL.getAllTables();
                String newName = name.getText();
                boolean exists = false;
                for (String s : db) {
                    if (newName.equals(s)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    // If it doesn't exist writes log, hides error message, adds table and closes this window
                    writing.writeLog(getClass(), " -> Add");
                    error.setVisible(false);
                    Add.add(newName);
                    dispatchEvent(new WindowEvent(AddTable.this, WindowEvent.WINDOW_CLOSING));
                } else {
                    // Writes log and closes this window
                    writing.writeLog(getClass(), "Show error");
                    error.setVisible(true);
                }
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
                dispatchEvent(new WindowEvent(AddTable.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
