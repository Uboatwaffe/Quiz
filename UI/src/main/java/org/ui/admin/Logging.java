package org.ui.admin;

import org.connecting.LoggingIn;
import org.ui.Main;
import org.ui.others.WrongPassword;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Logging implements ActionListener {
    // UI for logging into AdminPanel
    private final JFrame frame;
    private final JTextField login = new JTextField("Login");
    private final JTextField password = new JTextField("Password");

    public Logging() {
        frame = new JFrame("Logging in");

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Please log in: ");
        welcome.setBounds(5, 5, 200, 15);


        // Buttons
        JButton no = new JButton("CLOSE");
        JButton delete = new JButton("LOG IN");

        no.setBounds(325, 25, 80, 95);
        delete.setBounds(5, 90, 300, 30);

        no.addActionListener(this);
        delete.addActionListener(this);

        // Text-field
        password.setBounds(5, 55, 300, 30);
        login.setBounds(5, 25, 300, 30);

        // Adding to the frame
        frame.add(welcome);
        frame.add(login);
        frame.add(no);
        frame.add(delete);
        frame.add(password);


        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CLOSE")) {
            Main main = new Main();
            main.showMain();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }else if (e.getActionCommand().equals("LOG IN")) {
            if (login.getText().equals(LoggingIn.getLoginAndPassword()[0]) && password.getText().equals(LoggingIn.getLoginAndPassword()[1])) {
                new AdminPanel();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }else {
                new WrongPassword();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
