package org.ui.swing.score;

import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Incorrect extends JFrame {
    private JPanel panel;
    private JButton understoodButton;
    private JLabel incorrect;
    private JLabel user_input;
    private JLabel answer;

    Writing writing = new Writing();
    public Incorrect(String answer, String user_input) {
        writing.writeLog(Incorrect.class, "Constructor()");

        this.answer.setText("Correct answer was: " + answer);
        this.user_input.setText("You inserted: " + user_input);

        setContentPane(panel);
        setTitle("Incorrect");
        setSize(540, 210);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        understoodButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Incorrect.class, " <- Close");
                dispatchEvent(new WindowEvent(Incorrect.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
