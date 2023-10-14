package org.ui.others;

import org.manage.HowMany;
import org.manage.SQL;
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

    public Info(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
