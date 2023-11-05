package org.new_ui.swing.score;

import org.score.Count;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Correct extends JFrame {
    private JPanel panel;
    private JButton close;
    private JLabel correct;
    private JLabel score;

    public Correct() {
        score.setText("Your score is equal to: " + Count.getCount());

        setContentPane(panel);
        setTitle("Question");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(Correct.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
