package org.ui.swing.admin;

import org.db.manage.Deleting;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class DeleteQ extends JFrame {
    private JTextField textField;
    private JButton delete;
    private JButton close;
    private JLabel welcome;
    private JLabel how_to;
    private JPanel panel;
    Writing writing = new Writing();
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
             *
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
             *
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
