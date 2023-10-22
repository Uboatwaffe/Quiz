package org.ui.admin;

import org.db.manage.SQL;
import org.db.tables.Add;
import org.file.writing.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for adding tables
 * @author Maciej
 * @version 0.1
 */
class TableAdd implements ActionListener {
    /**
     * Frame of the class
     */
    private final JFrame frame;

    /**
     * Text field for new table name
     */
    private final JTextField login = new JTextField("New name");

    /**
     * Label informing about name being in usage
     */
    private final JLabel error = new JLabel("This name is already taken!");

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Constructor
     */
    TableAdd() {
        // Writing log
        writing.writeLog(getClass(), "Adding table");

        // Default settings
        frame = new JFrame("Adding table");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Insert new name for the table: ");
        welcome.setBounds(5, 5, 200, 15);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("OK");

        // Setting bounds
        error.setBounds(5, 25, 200, 15);
        no.setBounds(325, 25, 80, 95);
        ok.setBounds(5, 85, 300, 35);

        // Adding action listeners
        no.addActionListener(this);
        ok.addActionListener(this);

        // Text-field
        login.setBounds(5, 45, 300, 30);

        // Adding to the frame
        frame.add(welcome);
        frame.add(error);
        frame.add(login);
        frame.add(no);
        frame.add(ok);


        // Setting up the visibility
        error.setVisible(false);
        frame.setVisible(true);
    }
    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLOSE")) {

            // Writes log and closes this window
            writing.writeLog(getClass(), " <- Closing");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        } else if (e.getActionCommand().equals("OK")) {

            // Checks if given name exists
            String[] db = SQL.getAllTables();
            String newName = login.getText();
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
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            } else {
                // Writes log and closes this window
                writing.writeLog(getClass(), "Show error");
                error.setVisible(true);
            }
        }
    }
}
