package org.ui.swing.score;

import org.file.Writing;
import org.score.Count;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ShowScore extends JFrame {
    private JButton understoodButton;
    private JLabel score;
    private JPanel panel;

    Writing writing = new Writing();
    ShowScore() {
        writing.writeLog(ShowScore.class, "Constructor()");

        score.setText("Your final score: " + Count.getCount());

        setContentPane(panel);
        setTitle("Score");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        understoodButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(ShowScore.class, " <- Close");
                writing.writeLog(ShowScore.class, " -> MainSwing");
                new MainSwing();
                dispatchEvent(new WindowEvent(ShowScore.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
