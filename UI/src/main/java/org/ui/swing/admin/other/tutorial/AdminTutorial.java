package org.ui.swing.admin.other.tutorial;

import org.annotation.UI;
import org.file.Writing;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


/**
 * Class that is responsible for showing admins tutorial
 *
 * @author Maciej
 * @version 0.2
 */
@UI
public class AdminTutorial extends JFrame {

    /**
     * Content of the frame
     */
    private JButton close;

    /**
     * Content of the frame
     */
    private JLabel welcome;

    /**
     * Content of the frame
     */
    private JLabel introduction;

    /**
     * Content of the frame
     */
    private JLabel closed_ones;

    /**
     * Content of the frame
     */
    private JPanel panel;

    /**
     * Content of the frame
     */
    private JLabel TrueOrFalse_ones;

    /**
     * Content of the frame
     */
    private JLabel Open_ones;

    /**
     * Content of the frame
     */
    private JLabel About_date;

    /**
     * Object used to write log
     *
     * @see Writing
     */
    final Writing writing = new Writing();

    /**
     * Constructor
     */
    public AdminTutorial() {
        writing.writeLog(AdminTutorial.class, "Constructor()");

        setContentPane(panel);
        setTitle("Tutorial");
        setSize(540, 230);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        close.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                writing.writeLog(AdminTutorial.class, " <- Close");
                dispatchEvent(new WindowEvent(AdminTutorial.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
