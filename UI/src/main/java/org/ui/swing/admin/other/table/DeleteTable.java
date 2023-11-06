package org.ui.swing.admin.other.table;

import org.db.manage.SQL;
import org.db.tables.Delete;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for deleting tables from the DB
 *
 * @author Maciej
 * @version 0.2
 */
class DeleteTable extends JFrame {
    private final Writing writing = new Writing();

    /**
     * Content of the frame
     */
    private JTextField name;

    /**
     * Content of the frame
     */
    private JButton delete;

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
    private JLabel error;

    /**
     * Content of the frame
     */
    private JPanel panel;

    DeleteTable() {
        writing.writeLog(DeleteTable.class, "Constructor()");

        setContentPane(panel);
        setTitle("Deleting table");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        error.setVisible(false);

        setVisible(true);
        delete.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
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
                    writing.writeLog(DeleteTable.class, " <- Close");
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
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(DeleteTable.class, " <- Close");
                dispatchEvent(new WindowEvent(DeleteTable.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
