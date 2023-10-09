package org.ui.admin;

import org.manage.Deleting;
import org.manage.Sorting;
import org.manage.StringOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

class Manage implements ActionListener {
    JFrame frame = new JFrame("Deleting question");
    JTextField field = new JTextField();
    Sorting sorting = new Sorting();
    void delete(){
        frame = new JFrame("Deleting question");
        
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the admin panel!");
        welcome.setBounds(5, 5, 200, 15);

        JLabel question = new JLabel("What question do you want to delete? (Index of it; -1=all)");
        question.setBounds(5, 30, 400, 15);

        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("DELETE QUESTION");

        no.setBounds(335, 5, 80, 115);
        delete.setBounds(5, 90, 300, 30);

        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        field.setBounds(5, 50, 300, 30);

        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(no);
        frame.add(delete);
        frame.add(field);


        // Setting up the visibility
        frame.setVisible(true);
    }

        void add(){
            frame = new JFrame("Adding question");

            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setSize(440, 170);
            frame.setLayout(null);

            // Labels
            JLabel welcome = new JLabel("Welcome to the admin panel!");
            welcome.setBounds(5, 5, 200, 15);

            JLabel question = new JLabel("Please insert question in this way: question; answer, type");
            question.setBounds(5, 30, 400, 15);

            // Buttons
            JButton no = new JButton("CLOSE");
            JButton delete = new JButton("ADD QUESTION");

            no.setBounds(335, 5, 80, 115);
            delete.setBounds(5, 90, 300, 30);

            no.addActionListener(this);
            delete.addActionListener(this);

            // Text-field
            field.setBounds(5, 50, 300, 30);

            // Adding to the frame
            frame.add(welcome);
            frame.add(question);
            frame.add(no);
            frame.add(delete);
            frame.add(field);


            // Setting up the visibility
            frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CLOSE")){
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("DELETE QUESTION")) {
            Deleting.delete(field.getText());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (e.getActionCommand().equals("ADD QUESTION")) {
            StringOperations.addQuestion(field.getText());
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        }
    }
}