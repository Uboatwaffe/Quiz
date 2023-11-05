package org.ui.swing.admin;

import org.db.interfaces.Functional;
import org.db.interfaces.Functional2;
import org.db.manage.StringOperations;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class AddQ extends JFrame {

    Writing writing = new Writing();
    /**
     * Lambda responsible for extracting data from one String chain
     * into 3 records array
     */
    private final Functional toArray = (chain) -> {
        String[] db = null;
        try {
            // Writing log
            writing.writeLog(getClass(), "In lambda 'toArray'");

            // Creating array
            db = new String[3];

            // Extracting useful info from given string
            db[0] = chain.substring(0, chain.indexOf(";")).trim();
            db[1] = chain.substring(chain.indexOf(";") + 1, chain.lastIndexOf(";")).trim();
            db[2] = chain.substring(chain.lastIndexOf(";") + 1).trim();
        } catch (Exception ignore) {
        }

        // Returns array with info
        return db;
    };
    /**
     * Lambda responsible for checking if type of the question is correct
     * and also for checking if any of the questions doesn't contain '.' except for
     * questions about date
     */
    private final Functional2 checking = (chain) -> {
        // Writing log
        writing.writeLog(getClass(), "In lambda 'checking'");

        // Creating array with all info
        String[] db = toArray.toArray(chain);

        boolean correct = false;

        // If type of question is incorrect or question contains '.' (w/out date question) returns false
        switch (db[2]) {
            case "o", "c", "t" -> {
                if (!db[0].contains(".")) {
                    correct = true;
                }
            }
            case "d" -> correct = true;
        }

        // Returns true if everything is correct otherwise false
        return correct;
    };
    private JPanel panel;
    private JTextField textField;
    private JButton AddQ;
    private JButton close;
    private JLabel welcome;
    private JLabel how_to;

    AddQ() {
        setContentPane(panel);
        setTitle("Add Question");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(AddQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        AddQ.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Writes log, adds question and closes this window
                writing.writeLog(getClass(), " -> StringOperations");
                StringOperations.addQuestion(toArray, checking, textField.getText());
                dispatchEvent(new WindowEvent(org.ui.swing.admin.AddQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
