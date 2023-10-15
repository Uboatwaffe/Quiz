package org.ui.others;

import org.exceptions.ExceptionUI;
import org.file.writing.Writing;
import org.ui.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * UI for showing that inserted password/login was incorrect
 * @author Maciej
 * @version 0.1
 */
public class WrongPassword implements ActionListener {
    // UI that informs about inserting wrong password/login
    private final JFrame frame = new JFrame("Quiz");
    private final static Writing writing = new Writing();
    private final Main main = new Main();

    public WrongPassword() throws IOException {
        writing.writeLog(getClass(), "Wrong password");
        // Default settings
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("UNFORTUNATELY");
        welcome.setBounds(160, 5, 150, 15);

        JLabel info = new JLabel("Your login or password was incorrect");
        info.setBounds(100, 25, 300, 15);

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
            try {
                writing.writeLog(getClass(), "Closing");
            } catch (IOException ex) {
                new ExceptionUI(getClass());
            }
            main.showMain();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
