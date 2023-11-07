package org.ui.swing.other;

import org.file.Writing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for showing credits
 *
 * @author Maciej
 * @version 0.2
 */
public class Credits extends JFrame {

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JButton understood;

    /**
     * Content of the frame
     */
    private JLabel CREDITS;

    /**
     * Content of the frame
     */
    private JLabel con1;

    /**
     * Content of the frame
     */
    private JLabel con2;

    /**
     * Content of the frame
     */
    private JLabel start;

    /**
     * Content of the frame
     */
    private JLabel end;

    /**
     * Content of the frame
     */
    private JLabel company;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
    public Credits() {
        writing.writeLog(Credits.class, "Constructor()");

        setContentPane(panel);
        setTitle("Credits");
        setSize(410, 230);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        understood.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(Credits.class, " <- Close");
                dispatchEvent(new WindowEvent(Credits.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}