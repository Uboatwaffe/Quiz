package org.ui.admin;

import org.file.writing.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for giving the option for what to do
 * @author Maciej
 * @version 0.1
 */
class TablesManage implements ActionListener {
    /**
     * Frame of the table
     */
    private final JFrame frame;

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Constructor
     */
    TablesManage() {
        // Writing log
        writing.writeLog(getClass(), "Tables management");

        // Default settings
        frame = new JFrame("What to do");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("What do you want to do?");
        welcome.setBounds(5, 5, 200, 15);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton addTable = new JButton("ADD TABLE");
        JButton deleteTable = new JButton("DELETE TABLE");

        // Setting bounds
        no.setBounds(325, 25, 80, 95);
        addTable.setBounds(5, 25, 300, 45);
        deleteTable.setBounds(5, 75, 300, 45);

        // Adding action listeners
        no.addActionListener(this);
        addTable.addActionListener(this);
        deleteTable.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(no);
        frame.add(addTable);
        frame.add(deleteTable);


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
            case "ADD TABLE" -> {
                //Writes log and shows UI for adding table
                writing.writeLog(getClass(), "Goto table add");
                new TableAdd();
            }
            case "DELETE TABLE" -> {
                //Writes log and shows UI for deleting table
                writing.writeLog(getClass(), "Goto table delete");
                new TableDelete();
            }
            default -> {
                //Writes log and closes this window
                writing.writeLog(getClass(), "Closing");
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
