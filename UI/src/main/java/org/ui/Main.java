package org.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import org.connecting.HowMany;
import org.ui.hq.HQ;
import org.ui.questions.Count;
import org.ui.tutorial.Tutorial;
import org.connecting.Connect;

public class Main implements ActionListener {
    static Connect connect = new Connect();
    HQ hq = new HQ();
    HowMany howMany = new HowMany();
    JFrame frame = new JFrame("Quiz");
    JFrame frame2 = new JFrame("Score");
    JFrame frame3 = new JFrame("Are you ready?");

    JLabel score = new JLabel(String.valueOf(Count.count));

    Main(){
        // Main
        // Default settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(190,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the quiz!");
        welcome.setBounds(5, 5, 150, 15);

        JLabel question = new JLabel("Are you ready to start?");
        question.setBounds(5,30, 170, 15);

        // Buttons
        JButton yes = new JButton("YES");
        JButton no = new JButton("NO");
        JButton admin = new JButton("ADMIN PANEL");
        JButton tutorial = new JButton("TUTORIAL");

        yes.setBounds(5, 55, 80, 20);
        no.setBounds(90, 55, 80, 20);
        tutorial.setBounds(5, 80, 165, 20);
        admin.setBounds(5, 105, 165, 20);

        yes.addActionListener(this);
        no.addActionListener(this);
        tutorial.addActionListener(this);
        admin.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(yes);
        frame.add(no);
        frame.add(tutorial);
        frame.add(admin);

        // Setting up the visibility
        frame.setVisible(true);

        // Second
        // Default settings
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(190,170);
        frame2.setLayout(null);

        // Labels
        JLabel info = new JLabel("You scored: ");
        info.setBounds(5, 5, 150, 15);


        score.setBounds(5,30, 170, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 165, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame2.add(info);
        frame2.add(score);
        frame2.add(understood);

        // Third
        // Default settings
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(190,170);
        frame3.setLayout(null);

        // Labels
        JLabel info2 = new JLabel("Are you ready to get to");
        info2.setBounds(5, 5, 150, 15);

        JLabel info3 = new JLabel("know your score?");
        info3.setBounds(5, 30, 150, 15);

        // Button
        JButton iam = new JButton("I AM");

        iam.setBounds(5, 65, 80, 60);

        iam.addActionListener(this);

        JButton iamnot = new JButton("I'M NOT");

        iamnot.setBounds(90, 65, 80, 60);

        iamnot.addActionListener(this);

        frame3.add(info2);
        frame3.add(info3);
        frame3.add(iam);
        frame3.add(iamnot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NO")){
            System.exit(0);
        } else if (e.getActionCommand().equals("YES")) {
            frame.setVisible(false);
            frame3.setVisible(true);
            frame2.setVisible(false);
            hq.start();
            try {
                hq.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("TUTORIAL")) {
            new Tutorial();
        } else if (e.getActionCommand().equals("UNDERSTOOD")) {
            frame2.setVisible(false);
            frame.setVisible(true);
        } else if (e.getActionCommand().equals("I AM")) {
            frame3.setVisible(false);
            score.setText(Count.count + " out of " + howMany.howMany());
            frame2.setVisible(true);
            frame.setVisible(false);
        } else if (e.getActionCommand().equals("I'M NOT")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}