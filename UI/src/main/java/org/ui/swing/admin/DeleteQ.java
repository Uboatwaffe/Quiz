package org.ui.swing.admin;

import org.db.manage.Deleting;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for deleting questions from the DB
 *
 * @author Maciej
 * @version 0.2
 */
class DeleteQ extends JFrame {

    /**
     * Content of the frame
     */
    private JTextField textField;

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
    private JLabel welcome;

    /**
     * Content of the frame
     */
    private JLabel how_to;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    Writing writing = new Writing();

    /**
     * Constructor
     */
    DeleteQ() {
        writing.writeLog(DeleteQ.class, "Constructor()");

        setContentPane(panel);
        setTitle("Delete Question");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        delete.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Writes log, deletes question and closes this window
                writing.writeLog(DeleteQ.class, " -> Deleting");
                Deleting.delete(textField.getText());
                writing.writeLog(DeleteQ.class, " <- Close");
                dispatchEvent(new WindowEvent(DeleteQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(DeleteQ.class, " <- Close");
                dispatchEvent(new WindowEvent(DeleteQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
