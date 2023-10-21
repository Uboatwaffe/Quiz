package org.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.db.manage.HowMany;
import org.exceptions.ERRORS;
import org.file.writing.Writing;
import org.ui.hq.HQ;
import org.ui.others.Credit;
import org.ui.others.Info;
import org.ui.others.NoQuestions;
import org.ui.questions.Count;
import org.ui.tutorial.Tutorial;
import org.ui.admin.Logging;

/**
 * Main class
 * @author Maciej
 * @version 0.1
 */
public final class Main implements ActionListener{
    // Main class
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    private final HQ hq = new HQ();
    private final HowMany howMany = new HowMany();
    private final JFrame frame = new JFrame("Quiz");
    private final JFrame frame2 = new JFrame("Score");
    private final JFrame frame3 = new JFrame("Are you ready?");

    final JLabel score = new JLabel(String.valueOf(Count.getCount()));
    private final static Writing writing = new Writing();
    private final static ERRORS errors = new ERRORS();

    public Main(){
        // Main
        // Default settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Labels
        JLabel welcome = new JLabel("Welcome to the quiz!");
        welcome.setBounds(5, 5, 150, 15);

        JLabel question = new JLabel("Are you ready to start?");
        question.setBounds(5,30, 170, 15);

        // Buttons
        JButton yes = new JButton("START");
        JButton no = new JButton("CLOSE");
        JButton admin = new JButton("ADMIN PANEL");
        JButton tutorial = new JButton("TUTORIAL");
        JButton credit = new JButton("CREDITS");
        JButton info = new JButton("INFO");

        yes.setBounds(150, 5, 120, 50);
        no.setBounds(285, 5, 120, 50);
        tutorial.setBounds(5, 55, 130, 30);
        admin.setBounds(5, 90, 130, 30);
        credit.setBounds(285, 60, 120, 60);
        info.setBounds(150, 60, 120, 60);

        yes.addActionListener(this);
        no.addActionListener(this);
        tutorial.addActionListener(this);
        admin.addActionListener(this);
        credit.addActionListener(this);
        info.addActionListener(this);


        // Adding to the frame
        frame.add(welcome);
        frame.add(question);
        frame.add(yes);
        frame.add(no);
        frame.add(tutorial);
        frame.add(admin);
        frame.add(credit);
        frame.add(info);

        // Setting up the visibility
        frame.setVisible(true);

        // Second
        // Default settings
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(440,170);
        frame2.setLayout(null);

        // Labels
        JLabel information = new JLabel("You scored: ");
        information.setBounds(175, 5, 150, 15);

        score.setBounds(185,30, 170, 15);

        // Button
        JButton understood = new JButton("UNDERSTOOD");

        understood.setBounds(5, 65, 415, 60);

        understood.addActionListener(this);

        // Adding to the frame
        frame2.add(information);
        frame2.add(score);
        frame2.add(understood);

        // Third
        // Default settings
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(440,170);
        frame3.setLayout(null);

        // Labels
        JLabel info2 = new JLabel("Are you ready to get to");
        info2.setBounds(155, 5, 150, 15);

        JLabel info3 = new JLabel("know your score?");
        info3.setBounds(165, 30, 150, 15);

        // Button
        JButton iam = new JButton("I AM");

        iam.setBounds(5, 65, 205, 60);

        iam.addActionListener(this);

        JButton iamnot = new JButton("I'M NOT");

        iamnot.setBounds(215, 65, 205, 60);

        iamnot.addActionListener(this);

        frame3.add(info2);
        frame3.add(info3);
        frame3.add(iam);
        frame3.add(iamnot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "START" -> {
                writing.writeLog(getClass(),"Starting quiz");
                Count.setCount(0);
                if (howMany.howMany() != 0) {
                    frame.setVisible(false);
                    frame3.setVisible(true);
                    frame2.setVisible(false);
                    hq.start();
                    try {
                        hq.join();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    new NoQuestions();
                }
            }
            case "TUTORIAL" -> {
                writing.writeLog(getClass(),"Goto Tutorial");
                new Tutorial();
            }
            case "UNDERSTOOD" -> {
                writing.writeLog(getClass(),"Goto main menu");
                frame2.setVisible(false);
                frame.setVisible(true);
            }
            case "I AM" -> {
                writing.writeLog(getClass(),"Showing score");
                frame3.setVisible(false);
                score.setText(Count.getCount() + " out of " + howMany.howMany());
                frame2.setVisible(true);
                frame.setVisible(false);
            }
            case "I'M NOT" -> {
                writing.writeLog(getClass(),"Not showing score");
                showMain();
            }
            case "ADMIN PANEL" -> {
                writing.writeLog(getClass(),"Goto logging in");
                frame.setVisible(false);
                new Logging();
            }
            case "CREDITS" -> {
                writing.writeLog(getClass(),"Showing credits");
                new Credit();
            }
            case "INFO" -> {
                writing.writeLog(getClass(), "Showing info");
                new Info();
            }
            default -> {
                writing.writeLog(getClass(), "Ending");
                System.exit(0);
            }
        }
    }

    public void hideMain(){
        frame.setVisible(false);
    }

    public void showMain(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        errors.clear();
        writing.clear();
        writing.writeLog(Main.class,"Start program");
        SwingUtilities.invokeLater(Main::new);

    }
}