package org.ui.swing.admin;

import org.annotation.LambdaUsage;
import org.annotation.UI;
import org.db.interfaces.Functional;
import org.db.interfaces.Functional2;
import org.db.manage.StringOperations;
import org.file.Writing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for allowing user to add questions to the DB
 *
 * @author Maciej
 * @version 0.2
 */
@UI
class AddQ extends JFrame {

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();
    /**
     * Lambda responsible for extracting data from one String chain
     * into 3 records array
     */

    @LambdaUsage
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
    @LambdaUsage
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

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JTextField textField;

    /**
     * Content of the frame
     */
    private JButton AddQ;

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
     * Constructor
     */
    AddQ() {
        writing.writeLog(AddQ.class, "Constructor()");

        setContentPane(panel);
        setTitle("Add Question");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());

        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AddQ.class, " <- Close");
                dispatchEvent(new WindowEvent(AddQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        AddQ.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Writes log, adds question and closes this window
                writing.writeLog(getClass(), " -> StringOperations");
                StringOperations.addQuestion(toArray, checking, textField.getText());
                writing.writeLog(AddQ.class, " <- Close");
                dispatchEvent(new WindowEvent(org.ui.swing.admin.AddQ.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
