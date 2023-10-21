package org.ui.admin;

import org.db.interfaces.Functional;
import org.db.interfaces.Functional2;
import org.db.manage.Deleting;
import org.db.manage.StringOperations;
import org.file.writing.Writing;

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
     * - new question
     * - index of question that will be deleted
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
    final Functional toArray = (chain) -> {
        writing.writeLog(getClass(), "In lambda 'toArray'");
        String[] db = new String[3];
        db[0] = chain.substring(0, chain.indexOf(";")).trim();
        db[1] = chain.substring(chain.indexOf(";") + 1, chain.lastIndexOf(";")).trim();
        db[2] = chain.substring(chain.lastIndexOf(";") + 1).trim();

        return db;
    };

    /**
     * Lambda responsible for checking if type of the question is correct
     * and also for checking if any of the questions doesn't contain '.' except for
     * questions about date
     */
    final Functional2 checking = (chain) -> {
        writing.writeLog(getClass(), "In lambda 'checking'");
        String[] db = toArray.toArray(chain);

        boolean correct = false;

        switch (db[2]){
            case "o", "c", "t" -> {
                if(!db[0].contains(".")){
                    correct = true;
                }
            }
            case "d" -> correct = true;
        }
        return correct;
    };

    /**
     * Method that shows UI for deleting questions
     */
    void delete() {
        writing.writeLog(getClass(), "Deleting question");

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

        no.setBounds(335, 5, 80, 115);
        delete.setBounds(5, 90, 300, 30);

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
        writing.writeLog(getClass(), "Adding question");

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

        no.setBounds(335, 5, 80, 115);
        delete.setBounds(5, 90, 300, 30);

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
                writing.writeLog(getClass(), "Goto backend/deleting");
                Deleting.delete(field.getText());
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            case "ADD QUESTION" -> {
                writing.writeLog(getClass(), "Goto backend/string operations");
                StringOperations.addQuestion(toArray, checking, field.getText());
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            default -> {
                writing.writeLog(getClass(), "Closing");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
