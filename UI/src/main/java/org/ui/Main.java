package org.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    Main(){
        // Default settings
        JFrame frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(190,160);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the quiz!");
        welcome.setBounds(5, 5, 150, 15);

        JLabel question = new JLabel("Are you ready to get started?");
        question.setBounds(5,30, 170, 15);

        // Buttons
        JButton yes = new JButton("YES");
        JButton no = new JButton("NO");
        JButton admin = new JButton("ADMIN PANEL");

        yes.setBounds(5, 55, 80, 20);
        no.setBounds(90, 55, 80, 20);
        admin.setBounds(5, 80, 165, 20);


        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(yes);
        frame.add(no);
        frame.add(admin);

        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}