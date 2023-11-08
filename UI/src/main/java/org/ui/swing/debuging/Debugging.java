package org.ui.swing.debuging;

import org.ui.Main;
import org.uiProperties.Properties;

import javax.swing.*;
import java.awt.event.*;

/**
 * Class that allows to manipulate properties and makes debugging easier
 *
 * @author Maciej
 * @version 0.1
 */
public class Debugging extends JFrame {
    private JPanel panel;
    private JButton errorsButton;
    private JButton logButton;
    private JButton closeButton;
    private JCheckBox resizable;
    private JLabel welcome;

    public Debugging() {
        setContentPane(panel);
        setTitle("Debugging");
        setSize(540, 170);
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
                System.out.println(e.getStateChange());
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
                Main main = new Main();
                main.showMain();
                dispatchEvent(new WindowEvent(Debugging.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
