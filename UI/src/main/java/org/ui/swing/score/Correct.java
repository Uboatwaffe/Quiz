package org.ui.swing.score;

import org.file.Writing;
import org.score.Count;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Correct extends JFrame {

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JLabel correct;

    /**
     * Content of the frame
     */
    private JLabel score;

    Writing writing = new Writing();
    public Correct() {
        writing.writeLog(Correct.class, "Constructor()");

        score.setText("Your score is equal to: " + Count.getCount());

        setContentPane(panel);
        setTitle("Correct");
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
                writing.writeLog(Correct.class, " <- Close");
                dispatchEvent(new WindowEvent(Correct.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
