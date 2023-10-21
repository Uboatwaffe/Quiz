package org.ui.admin.others;

import org.file.writing.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing who made this program
 * @author Maciej
 * @version 0.1
 */
public class Credit implements ActionListener {
    // UI that shows who made this program
    private final JFrame frame = new JFrame("Credits");
    private final static Writing writing = new Writing();
    /**
     * Constructor
     */
    public Credit() {
        writing.writeLog(getClass(),"Credits");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(210,280);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("CREDITS:");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("User Interface -- Contributor 2");
        string2.setBounds(5,30, 200, 15);

        JLabel string3 = new JLabel("Project structure -- Contributor 1");
        string3.setBounds(5,55, 200, 15);

        JLabel string4 = new JLabel("Start of realisation -- 07.10.2023");
        string4.setBounds(5,80, 200, 15);

        JLabel string5 = new JLabel("End of realisation -- ??.10.2023");
        string5.setBounds(5,105, 200, 15);

        JLabel string6 = new JLabel("Company -- ");
        string6.setBounds(5,130, 200, 15);

        JLabel string7 = new JLabel("VI LO im. J. i J. Śniadeckich");
        string7.setBounds(5,155, 200, 15);

        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 180, 185, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
        frame.add(string4);
        frame.add(string5);
        frame.add(string6);
        frame.add(string7);
        frame.add(understood);


        // Setting up the visibility
        frame.setVisible(true);
    }
    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        writing.writeLog(getClass(), "Closing");
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
