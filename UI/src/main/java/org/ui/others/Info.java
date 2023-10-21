package org.ui.others;

import org.db.manage.HowMany;
import org.db.manage.SQL;
import org.file.writing.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI for showing info about current set
 * @author Maciej
 * @version 0.1
 */
public class Info implements ActionListener {
    // UI that shows info about current set
    private final JFrame frame = new JFrame("Info");
    private final static Writing writing = new Writing();
    /**
     * Constructor
     */
    public Info() {
        writing.writeLog(getClass(),"Info");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(210,175);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("INFO:");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("Current set: " + SQL.getCurrentTable());
        string2.setBounds(5,30, 200, 15);

        HowMany howMany = new HowMany();
        JLabel string3 = new JLabel("Number of questions: " + howMany.howMany());
        string3.setBounds(5,55, 200, 15);



        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5,80, 185, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
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
        writing.writeLog(getClass(),"Closing");
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
