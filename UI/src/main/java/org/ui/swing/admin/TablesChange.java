package org.ui.swing.admin;

import org.db.manage.SQL;
import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for changing tables
 * @author Maciej
 * @version 0.1
 */
class TablesChange implements ActionListener {
    /**
     * Frame of the class
     */
    private final JFrame frame;

    /**
     * Field that stores default table name
     */
    private String prevTable = "set1";

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();
    /**
     * Constructor
     */
    TablesChange() {
        // Writing log
        writing.writeLog(getClass(), "Constructor");

        // Default settings
        frame = new JFrame("Changing table");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Current table: " + SQL.getCurrentTable());
        welcome.setBounds(5, 5, 200, 15);

        // Initializing list and scroll panel
        JList<String> list = new JList<>(SQL.getAllTables());
        JScrollPane pane = new JScrollPane(list);

        pane.setBounds(5, 25, 300, 60);

        // When record is clicked saves its name in 'prevTable'
        list.addListSelectionListener(e -> prevTable = list.getSelectedValue());


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("OK");

        // Setting bounds
        no.setBounds(325, 25, 80, 95);
        ok.setBounds(5, 90, 300, 30);

        // Adding action listeners
        no.addActionListener(this);
        ok.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(pane);
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
        if (e.getActionCommand().equals("OK")) {
            // Writes log, sets new current table and then closes this window
            writing.writeLog(getClass(), " -> SQL");
            SQL.setCurrentTable(prevTable);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("CLOSE")) {
            // Writes log and closes this window
            writing.writeLog(getClass(), " <- Closing");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
