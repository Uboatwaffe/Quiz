package org.ui.others;

import org.ui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NoQuestions implements ActionListener {
    private final JFrame frame = new JFrame("Quiz");
    private final Main main = new Main();

    public NoQuestions() {

        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("UNFORTUNATELY");
        welcome.setBounds(160, 5, 150, 15);

        JLabel info = new JLabel("There aren't questions");
        info.setBounds(145, 25, 300, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame.add(welcome);
        frame.add(info);
        frame.add(understood);

        // Setting up the visibility
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("UNDERSTOOD")) {
            main.showMain();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
