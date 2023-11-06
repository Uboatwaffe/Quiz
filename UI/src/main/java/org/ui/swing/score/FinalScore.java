package org.ui.swing.score;

import org.file.Writing;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class FinalScore extends JFrame {
    private JButton iDoButton;
    private JButton iDonTButton;
    private JLabel what_to_do;
    private JPanel panel;

    Writing writing = new Writing();
    public FinalScore() {
        writing.writeLog(FinalScore.class, "Constructor()");

        setContentPane(panel);
        setTitle("Score");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        iDoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(FinalScore.class, " <- Closing");
                writing.writeLog(FinalScore.class, " -> ShowScore");

                new ShowScore();
                dispatchEvent(new WindowEvent(FinalScore.this, WindowEvent.WINDOW_CLOSING));
            }
        });
        iDonTButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(FinalScore.class, " <- Closing");
                writing.writeLog(FinalScore.class, " -> MainSwing");

                new MainSwing();
                dispatchEvent(new WindowEvent(FinalScore.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
