package org.new_ui.swing.admin.other.table;

import org.db.manage.SQL;
import org.db.tables.Delete;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class DeleteTable extends JFrame {
    private final Writing writing = new Writing();
    private JTextField name;
    private JButton delete;
    private JButton close;
    private JLabel info;
    private JLabel error;
    private JPanel panel;

    DeleteTable() {
        setContentPane(panel);
        setTitle("Deleting table");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        error.setVisible(false);

        setVisible(true);
        delete.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Checks if given name exists
                String[] db = SQL.getAllTables();
                String newName = name.getText();
                boolean exists = false;
                for (String s : db) {
                    if (newName.equals(s) && !newName.equals("set1")) {
                        exists = true;
                        break;
                    }
                }


                if (exists) {

                    // If it exists writes log, hides error message, deletes table and closes this window
                    writing.writeLog(getClass(), " -> Delete");
                    error.setVisible(false);
                    Delete.delete(newName);
                    dispatchEvent(new WindowEvent(DeleteTable.this, WindowEvent.WINDOW_CLOSING));

                } else {

                    //Writes log and closes this window
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
                dispatchEvent(new WindowEvent(DeleteTable.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
