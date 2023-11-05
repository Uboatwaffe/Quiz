package org.new_ui.swing.admin.other.tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminTutorial extends JFrame {
    private JButton close;
    private JLabel welcome;
    private JLabel introduction;
    private JLabel closed_ones;
    private JPanel panel;
    private JLabel TrueOrFalse_ones;
    private JLabel Open_ones;
    private JLabel About_date;

    public AdminTutorial() {
        setContentPane(panel);
        setTitle("Tutorial");
        setSize(540, 230);
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
                dispatchEvent(new WindowEvent(AdminTutorial.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
