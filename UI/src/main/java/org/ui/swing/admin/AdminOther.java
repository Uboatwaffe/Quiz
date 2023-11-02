package org.ui.swing.admin;

import org.db.reset.Reset;
import org.file.Writing;
import org.ui.swing.tutorial.AdminTutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing other options of admin panel
 * @author Maciej
 * @version 0.1
 */
public class AdminOther implements ActionListener {

    /**
     * Frame of the class
     */
    private final JFrame frame = new JFrame("Other");

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * Constructor
     */
    public AdminOther() {
        // Writing log
        writing.writeLog(getClass(), "Constructor");

        // Default settings
        frame.setSize(440, 170);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(null);

        // Buttons
        JButton tutorial = new JButton("TUTORIAL");
        JButton changePassword = new JButton("DETAILS");
        JButton close = new JButton("CLOSE");
        JButton reset = new JButton("RESET");
        JButton addT = new JButton("TABLE MANAGEMENT");
        JButton changeTable = new JButton("CHANGE TABLE");

        // Setting bounds
        tutorial.setBounds(180, 5, 150, 55);
        changePassword.setBounds(180, 65, 150, 55);
        close.setBounds(335, 5, 80, 55);
        reset.setBounds(335, 65, 80, 55);
        addT.setBounds(5, 5, 170, 55);
        changeTable.setBounds(5, 65, 170, 55);

        // Adding action listeners
        tutorial.addActionListener(this);
        changePassword.addActionListener(this);
        changeTable.addActionListener(this);
        close.addActionListener(this);
        addT.addActionListener(this);
        reset.addActionListener(this);

        // Adding to the frame
        frame.add(addT);
        frame.add(close);
        frame.add(tutorial);
        frame.add(changePassword);
        frame.add(changeTable);
        frame.add(reset);

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
            case "TUTORIAL" -> {
                // Writing log and going to the AdminTutorial()
                writing.writeLog(getClass(), " -> AdminTutorial");
                new AdminTutorial();
            }
            case "DETAILS" -> {
                // Writing log and going to NewPassword()
                writing.writeLog(getClass(), " -> NewPassword");
                new NewPassword();
            }
            case "CHANGE TABLE" -> {
                // Writing log and going to TablesChange()
                writing.writeLog(getClass(), " -> TablesChange");
                new TablesChange();
            }
            case "TABLE MANAGEMENT" -> {
                // Writing log and going to TablesManage()
                writing.writeLog(getClass(), " -> TableManage");
                new TablesManage();
            }
            case "RESET" -> {
                // Writing log going to Reset() and closing this window
                writing.writeLog(getClass(), " -> Reset");
                Reset.reset();
                frame.dispatchEvent((new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
            }
            default -> {
                // Writing log and closing this window
                writing.writeLog(getClass(), " <- Closing");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
