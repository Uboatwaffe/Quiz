package org.ui.swing.debuging;

import org.exceptions.ui.ExceptionUI;
import org.ui.Main;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Class that allows to manipulate properties and makes debugging easier
 *
 * @author Maciej
 * @version 0.1
 */
public class Debugging extends JFrame {

    /**
     * Field that returns properties to default if any change wasn't made
     */
    Boolean change = false;
    /**
     * Content of the frame
     */
    private JPanel panel;
    /**
     * Content of the frame
     */
    private JButton errorsButton;
    /**
     * Content of the frame
     */
    private JButton logButton;
    /**
     * Content of the frame
     */
    private JButton closeButton;
    /**
     * Content of the frame
     */
    private JCheckBox resizable;
    /**
     * Content of the frame
     */
    private JLabel welcome;

    /**
     * Constructor
     */
    public Debugging() {
        setContentPane(panel);
        setTitle("Debugging");
        setSize(540, 230);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(Properties.getScalable());
        resizable.addItemListener(new ItemListener() {
            /**
             * Invoked when an item has been selected or deselected by the user.
             * The code written for this method performs the operations
             * that need to occur when an item is selected (or deselected).
             *
             * @param e the event to be processed
             */
            @Override
            public void itemStateChanged(ItemEvent e) {
                Properties.setScalable(e.getStateChange() == ItemEvent.SELECTED);
                change = true;
            }
        });
        logButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openInBrowser("Backend\\src\\main\\resources\\log.txt");
                } catch (IOException ignore) {
                    new ExceptionUI(Debugging.class, "Couldn't open file");
                }
            }
        });
        errorsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openInBrowser("Exceptions\\src\\main\\resources\\errors.txt");
                } catch (IOException ignore) {
                    new ExceptionUI(Debugging.class, "Couldn't open file");
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!change) {
                    Properties.setScalable(false);
                }
                Main main = new Main();
                main.showMain();
                dispatchEvent(new WindowEvent(Debugging.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

    /**
     * Method that opens index.html in browser
     *
     * @param url path to the file
     * @throws IOException throws when error occurs
     */
    public static void openInBrowser(String url) throws IOException {
        File file = new File(url);
        Desktop.getDesktop().browse(file.toURI());
    }
}
