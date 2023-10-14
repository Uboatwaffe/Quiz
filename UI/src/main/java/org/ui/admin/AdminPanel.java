package org.ui.admin;

import org.ui.Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
/**
 * UI for showing admin panel
 * @author Maciej
 * @version 0.1
 */
public class AdminPanel implements ActionListener {
    // Main menu for AdminPanel
    private final JFrame frame = new JFrame("Admin Panel");
    private final Manage manage = new Manage();
    private final ShowAll showAll = new ShowAll();

    private final Main main = new Main();

    public AdminPanel() {
        main.hideMain();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(440, 170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the admin panel!");
        welcome.setBounds(5, 5, 200, 15);

        JLabel question = new JLabel("What do you want to do?");
        question.setBounds(5, 30, 170, 15);

        // Buttons
        JButton showQ = new JButton("SHOW QUESTIONS");
        JButton showA = new JButton("SHOW ANSWERS");
        JButton no = new JButton("CLOSE");
        JButton others = new JButton("OTHER");
        JButton add = new JButton("ADD QUESTION");
        JButton delete = new JButton("DELETE QUESTION");

        showQ.setBounds(180, 5, 150, 55);
        showA.setBounds(180, 65, 150, 55);
        no.setBounds(335, 5, 80, 55);
        add.setBounds(5, 55, 160, 30);
        delete.setBounds(5, 90, 160, 30);
        others.setBounds(335, 65, 80, 55);

        add.addActionListener(this);
        no.addActionListener(this);
        delete.addActionListener(this);
        showQ.addActionListener(this);
        showA.addActionListener(this);
        others.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(add);
        frame.add(no);
        frame.add(delete);
        frame.add(showQ);
        frame.add(showA);
        frame.add(others);

        // Setting up the visibility
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CLOSE")) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            main.showMain();
        }
        else if (e.getActionCommand().equals("SHOW QUESTIONS")) {
            showAll.ShowQuestions();
        }else if (e.getActionCommand().equals("SHOW ANSWERS")){
            showAll.ShowAnswers();
        } else if (e.getActionCommand().equals("ADD QUESTION")) {
            manage.add();
        } else if (e.getActionCommand().equals("DELETE QUESTION")) {
            manage.delete();
        } else if (e.getActionCommand().equals("OTHER")) {
            new AdminOther();
        }
    }
}
