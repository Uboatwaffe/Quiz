package org.ui.swing.score;

import org.annotation.UI;
import org.file.Writing;
import org.ui.swing.MainSwing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class that is responsible for delaying act of showing user his score to prevent from
 * <br>
 * to early initialisation of actual score which may not be right
 *
 * @author Maciej
 * @version 0.2
 */
@UI
public class FinalScore extends JFrame {

    /**
     * Content of the frame
     */
    private JButton iDoButton;

    /**
     * Content of the frame
     */
    private JButton iDonTButton;

    /**
     * Content of the frame
     */
    private JLabel what_to_do;

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
    public FinalScore() {
        writing.writeLog(FinalScore.class, "Constructor()");

        setContentPane(panel);
        setTitle("Score");
        setSize(540, 170);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        iDoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
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
