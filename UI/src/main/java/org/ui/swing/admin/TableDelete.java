package org.ui.swing.admin;

import org.db.manage.SQL;
import org.db.tables.Delete;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for deleting tables
 * @author Maciej
 * @version 0.1
 */
class TableDelete implements ActionListener {

    /**
     * Frame of the class
     */
    private final JFrame frame;

    /**
     * Text filed responsible for getting table name
     */
    private final JTextField login = new JTextField("Name of the table");

    /**
     * Label that tells user that he can't delete that table
     */
    private final JLabel error = new JLabel("There is no such table or it can't be deleted!");

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();
    /**
     * Constructor
     */
    TableDelete() {
        //Writes log
        writing.writeLog(getClass(), "Constructor()");

        // Default settings
        frame = new JFrame("Deleting table");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Insert name of the table: ");
        welcome.setBounds(5, 5, 200, 15);

        error.setBounds(5, 25, 300, 15);
        error.setVisible(false);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("DELETE");

        // Setting bounds
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

        } else if (e.getActionCommand().equals("DELETE")) {

            // Checks if given name exists
            String[] db = SQL.getAllTables();
            String newName = login.getText();
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
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            } else {

                //Writes log and closes this window
                writing.writeLog(getClass(), "Show error");
                error.setVisible(true);

            }
        }
    }
}


