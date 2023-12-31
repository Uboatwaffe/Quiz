package org.ui.swing.score;

import org.annotation.UI;
import org.file.Writing;
import org.score.Count;
import org.ui.swing.MainSwing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for showing final score to the user
 *
 * @author Maciej
 * @version 0.2
 */
@UI
public class ShowScore extends JFrame {

    /**
     * Content of the frame
     */
    private JButton understoodButton;

    /**
     * Content of the frame
     */
    private JLabel score;

    /**
     * Content of the frame
     */
    private JPanel panel;


    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
    ShowScore() {
        writing.writeLog(ShowScore.class, "Constructor()");

        score.setText("Your final score: " + Count.getCount());

        setContentPane(panel);
        setTitle("Score");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        understoodButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
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
