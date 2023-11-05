package org.new_ui.swing.score;

import org.new_ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class FinalScore extends JFrame {
    private JButton iDoButton;
    private JButton iDonTButton;
    private JLabel what_to_do;
    private JPanel panel;

    public FinalScore() {
        setContentPane(panel);
        setTitle("Question");
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
                new MainSwing();
                dispatchEvent(new WindowEvent(FinalScore.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
