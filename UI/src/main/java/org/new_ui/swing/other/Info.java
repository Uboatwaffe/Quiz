package org.new_ui.swing.other;

import org.db.manage.HowMany;
import org.db.manage.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Info extends JFrame {

    HowMany howMany = new HowMany();
    private JButton understood;
    private JPanel panel;
    private JLabel INFO;
    private JLabel set;
    private JLabel questions;

    public Info() {
        setSize(210, 175);
        setContentPane(panel);
        setTitle("Info");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        set.setText("Current set id: " + SQL.getCurrentTable());
        questions.setText("Number of questions in it: " + howMany.howMany());
        understood.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(Info.this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}