package org.ui.swing.score;

import org.file.Writing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for letting user know that his answer was incorrect
 * <br>
 * It also shows what answer was expected
 *
 * @author Maciej
 * @version 0.2
 */
public class Incorrect extends JFrame {

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton understoodButton;

    /**
     * Content of the frame
     */
    private JLabel incorrect;

    /**
     * Content of the frame
     */
    private JLabel user_input;

    /**
     * Content of the frame
     */
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
