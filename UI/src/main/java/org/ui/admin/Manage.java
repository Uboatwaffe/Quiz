package org.ui.admin;

import org.db.interfaces.Functional;
import org.db.interfaces.Functional2;
import org.db.manage.Deleting;
import org.db.manage.StringOperations;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for adding and deleting questions
 * @author Maciej
 * @version 0.1
 */
class Manage implements ActionListener {

    /**
     * Frame of the class
     */
    private JFrame frame = new JFrame("Deleting question");

    /**
     * Text field for getting:
     * <ul>
     *     <li>
     *          new question
     *      </li>
     *      <li>
     *          index of question that will be deleted
     *      </li>
     * </ul>
     */
    private final JTextField field = new JTextField();

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();


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
        switch (db[2]){
            case "o", "c", "t" -> {
                if(!db[0].contains(".")){
                    correct = true;
                }
            }
            case "d" -> correct = true;
        }

        // Returns true if everything is correct otherwise false
        return correct;
    };

    /**
     * Method that shows UI for deleting questions
     */
    void delete() {
        // Writes log
        writing.writeLog(getClass(), "Deleting question");

        // Default settings
        frame = new JFrame("Deleting question");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the admin panel!");
        welcome.setBounds(5, 5, 200, 15);

        JLabel question = new JLabel("What question do you want to delete? (Index of it; -1=all)");
        question.setBounds(5, 30, 400, 15);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("DELETE QUESTION");

        // Setting bounds
        no.setBounds(335, 5, 80, 115);
        delete.setBounds(5, 90, 300, 30);

        // Adding action listeners
        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        field.setBounds(5, 50, 300, 30);

        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(no);
        frame.add(delete);
        frame.add(field);


        // Setting up the visibility
        frame.setVisible(true);
    }

    /**
     * Method that shows UI responsible for adding question
     */
    void add() {
        // Writing log
        writing.writeLog(getClass(), "Constructor()");

        // Default settings
        frame = new JFrame("Adding question");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the admin panel!");
        welcome.setBounds(5, 5, 200, 15);

        JLabel question = new JLabel("Please insert question in this way: question; answer; type");
        question.setBounds(5, 30, 400, 15);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("ADD QUESTION");

        // Setting bounds
        no.setBounds(335, 5, 80, 115);
        delete.setBounds(5, 90, 300, 30);

        // Adding action listeners
        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        field.setBounds(5, 50, 300, 30);

        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(no);
        frame.add(delete);
        frame.add(field);


        // Setting up the visibility
        frame.setVisible(true);

    }
    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "DELETE QUESTION" -> {
                // Writes log, deletes question and closes this window
                writing.writeLog(getClass(), " -> Deleting");
                Deleting.delete(field.getText());
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            case "ADD QUESTION" -> {
                // Writes log, adds question and closes this window
                writing.writeLog(getClass(), " -> StringOperations");
                StringOperations.addQuestion(toArray, checking, field.getText());
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            default -> {
                // Writes log and closes this window
                writing.writeLog(getClass(), " <- Closing");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
