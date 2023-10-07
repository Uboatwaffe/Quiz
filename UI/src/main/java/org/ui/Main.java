package org.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ui.questions.*;

public class Main implements ActionListener {

    Main(){
        // Default settings
        JFrame frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(190,170);
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
        JButton tutorial = new JButton("TUTORIAL");

        yes.setBounds(5, 55, 80, 20);
        no.setBounds(90, 55, 80, 20);
        tutorial.setBounds(5, 80, 165, 20);
        admin.setBounds(5, 105, 165, 20);

        yes.addActionListener(this);
        no.addActionListener(this);
        tutorial.addActionListener(this);
        admin.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(yes);
        frame.add(no);
        frame.add(tutorial);
        frame.add(admin);

        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NO")){
            System.exit(0);
        } else if (e.getActionCommand().equals("YES")) {
            //new QuestionABC("C", "C");
            new QuestionDate("11.11.1111", "11.11.1111");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}