package org.ui.admin;

import org.db.manage.SQL;
import org.file.writing.Writing;

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
    // UI responsible for changing tables
    private final JFrame frame;
    private String prevTable = "set1";

    private static final Writing writing = new Writing();
    /**
     * Constructor
     */
    TablesChange() {
        writing.writeLog(getClass(), "Change tables");
        frame = new JFrame("Changing table");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Current table: " + SQL.getCurrentTable());
        welcome.setBounds(5, 5, 200, 15);

        JList<String> list = new JList<>(SQL.getAllTables());
        JScrollPane pane = new JScrollPane(list);

        pane.setBounds(5, 25, 300, 60);

        list.addListSelectionListener(e -> prevTable = list.getSelectedValue());


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton ok = new JButton("OK");

        no.setBounds(325, 25, 80, 95);
        ok.setBounds(5, 90, 300, 30);

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
            writing.writeLog(getClass(), "Goto backend/sql");
            SQL.setCurrentTable(prevTable);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("CLOSE")) {
            writing.writeLog(getClass(), "Closing");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
