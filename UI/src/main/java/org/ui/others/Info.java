package org.ui.others;

import org.manage.HowMany;
import org.manage.SQL;
import org.score.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Info implements ActionListener {
    // Default settings
    JFrame frame = new JFrame("Info");
    HowMany howMany = new HowMany();

    public Info(){
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(210,250);
        frame.setLayout(null);

        // Labels
        JLabel string1 = new JLabel("INFO:");
        string1.setBounds(5, 5, 150, 15);

        JLabel string2 = new JLabel("Current set: " + SQL.getCurrentTable());
        string2.setBounds(5,30, 200, 15);

        JLabel string3 = new JLabel("Number of questions: " + howMany.howMany());
        string3.setBounds(5,55, 200, 15);

        JLabel string4 = new JLabel("POINTS: ");
        string4.setBounds(5,80, 200, 15);

        String[] db = ScoreDB.getStats();

        JLabel string5 = new JLabel("Last: " + db[1] + "          All: " + db[2]);
        string5.setBounds(5, 105, 300, 15);

        JLabel string6;

        if(Integer.parseInt(db[0]) != 0) {
            string6 = new JLabel("Attempts: " + db[0] + "      Average: " + (Double.parseDouble(db[2]) / Double.parseDouble(db[0])));
        }else {
            string6 = new JLabel("Attempts: " + db[0]);
        }
        string6.setBounds(5, 130, 180, 15);

        // Buttons
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5,155, 185, 50);

        understood.addActionListener(this);


        // Adding to the frame
        frame.add(string1);
        frame.add(string2);
        frame.add(string3);
        frame.add(string4);
        frame.add(string5);
        frame.add(string6);
        frame.add(understood);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
