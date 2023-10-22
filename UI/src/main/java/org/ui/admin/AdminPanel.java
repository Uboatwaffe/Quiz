package org.ui.admin;

import org.file.writing.Writing;
import org.ui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing admin panel
 * @author Maciej
 * @version 0.1
 */
public class AdminPanel implements ActionListener {
    /**
     * Frame of the class
     */
    private final JFrame frame = new JFrame("Admin Panel");

    /**
     * Object that is responsible for adding/deleting questions
     */
    private final Manage manage = new Manage();

    /**
     * Object that is responsible for showing questions/answers
     */
    private final ShowAll showAll = new ShowAll();

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * Main class
     */
    private final Main main = new Main();

    /**
     * Constructor
     */
    public AdminPanel() {
        // Writing log
        writing.writeLog(getClass(), "Admin Panel");

        // Hiding main menu
        main.hideMain();

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the admin panel!");
        welcome.setBounds(5, 5, 200, 15);

        JLabel question = new JLabel("What do you want to do?");
        question.setBounds(5, 30, 170, 15);

        // Buttons
        JButton showQ = new JButton("SHOW QUESTIONS");
        JButton showA = new JButton("SHOW ANSWERS");
        JButton no = new JButton("CLOSE");
        JButton others = new JButton("OTHER");
        JButton add = new JButton("ADD QUESTION");
        JButton delete = new JButton("DELETE QUESTION");

        // Setting bounds
        showQ.setBounds(180, 5, 150, 55);
        showA.setBounds(180, 65, 150, 55);
        no.setBounds(335, 5, 80, 55);
        add.setBounds(5, 55, 160, 30);
        delete.setBounds(5, 90, 160, 30);
        others.setBounds(335, 65, 80, 55);

        // Adding action listeners
        add.addActionListener(this);
        no.addActionListener(this);
        delete.addActionListener(this);
        showQ.addActionListener(this);
        showA.addActionListener(this);
        others.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(add);
        frame.add(no);
        frame.add(delete);
        frame.add(showQ);
        frame.add(showA);
        frame.add(others);

        // Setting up the visibility
        frame.setVisible(true);
    }
    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "SHOW QUESTIONS" -> {
                // Writing log and showing questions
                writing.writeLog(getClass(), "Goto show questions");
                showAll.ShowQuestions();
            }
            case "SHOW ANSWERS" -> {
                // Writing log and showing answers
                writing.writeLog(getClass(), "Goto show answers");
                showAll.ShowAnswers();
            }
            case "ADD QUESTION" -> {
                // Writing log and going to class that will add question
                writing.writeLog(getClass(), "Goto add questions");
                manage.add();
            }
            case "DELETE QUESTION" -> {
                // Writing log and going to class that will delete question
                writing.writeLog(getClass(), "Goto delete question");
                manage.delete();
            }
            case "OTHER" -> {
                // Writing log and going to AdminOther()
                writing.writeLog(getClass(), "Goto admin other");
                new AdminOther();
            }
            default -> {
                // Writing log then closing this window and showing main menu
                writing.writeLog(getClass(), "Closing");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                main.showMain();
            }
        }
    }
}
