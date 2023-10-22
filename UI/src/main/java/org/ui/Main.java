package org.ui;

import org.db.manage.HowMany;
import org.exceptions.file.ERRORS;
import org.file.writing.Writing;
import org.ui.admin.Logging;
import org.ui.admin.others.Credit;
import org.ui.admin.others.Info;
import org.ui.admin.others.NoQuestions;
import org.ui.hq.HQ;
import org.ui.questions.Count;
import org.ui.tutorial.Tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
How to configure writing log?
When program calls other class use this ' -> CalledClass'
When program is in the constructor type this ' Constructor() '
When program closes current window type this ' <- Closing'
If program exits use this ' <- EXIT'
If program is doing anything else just describe this 'message'
 */

/**
 * Main class
 * @author Maciej
 * @version 0.1
 */
public final class Main implements ActionListener{
    // Main class

    /**
     * New Thread
     */
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    private final HQ hq = new HQ();

    /**
     * Object that is used to gain info about records from DB
     */
    private final HowMany howMany = new HowMany();

    /**
     * Frame nr 1 (Main)
     */
    private final JFrame frame = new JFrame("Quiz");

    /**
     * Frame nr 2 (Score)
     */
    private final JFrame frame2 = new JFrame("Score");

    /**
     * Frame nr 3 (Ready)
     */
    private final JFrame frame3 = new JFrame("Are you ready?");

    /**
     * Label containing current score
     */
    final JLabel score = new JLabel(String.valueOf(Count.getCount()));

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * Object used to write error log
     * @see ERRORS
     */
    private final static ERRORS errors = new ERRORS();

    /**
     * Constructor
     */
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

        // Setting bounds
        yes.setBounds(150, 5, 120, 50);
        no.setBounds(285, 5, 120, 50);
        tutorial.setBounds(5, 55, 130, 30);
        admin.setBounds(5, 90, 130, 30);
        credit.setBounds(285, 60, 120, 60);
        info.setBounds(150, 60, 120, 60);

        // Adding action listeners
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

        // Adding to the frame
        frame3.add(info2);
        frame3.add(info3);
        frame3.add(iam);
        frame3.add(iamnot);
    }

    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "START" -> {
                // Writes log
                writing.writeLog(getClass(),"Starting quiz");

                // Resets score
                Count.setCount(0);

                // Configures visibility
                if (howMany.howMany() != 0) {
                    frame.setVisible(false);
                    frame3.setVisible(true);
                    frame2.setVisible(false);

                    // Starts new thread
                    hq.start();
                    try {
                        // Waits till second thread is done
                        hq.join();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    // If there aren't any questions goes to NoQuestions()
                    writing.writeLog(getClass(), " -> NoQuestions");
                    new NoQuestions();
                }
            }
            case "TUTORIAL" -> {
                // Writes log and goes to Tutorial()
                writing.writeLog(getClass()," -> Tutorial");
                new Tutorial();
            }
            case "UNDERSTOOD" -> {
                // Writes log and configures visibility
                writing.writeLog(getClass()," -> Main.menu");
                frame2.setVisible(false);
                frame.setVisible(true);
            }
            case "I AM" -> {
                // Writes log and configures visibility and score
                writing.writeLog(getClass()," -> Main.score");
                frame3.setVisible(false);
                score.setText(Count.getCount() + " out of " + howMany.howMany());
                frame2.setVisible(true);
                frame.setVisible(false);
            }
            case "I'M NOT" -> {
                // Writes log and shows main menu
                writing.writeLog(getClass()," -> Main.menu");
                showMain();
            }
            case "ADMIN PANEL" -> {
                // Writes log and goes to Logging()
                writing.writeLog(getClass()," -> Logging");
                frame.setVisible(false);
                new Logging();
            }
            case "CREDITS" -> {
                // Writes log and goes to Credit()
                writing.writeLog(getClass()," -> Credit");
                new Credit();
            }
            case "INFO" -> {
                // Writes log and goes to Info()
                writing.writeLog(getClass(), " -> Info");
                new Info();
            }
            default -> {
                // Writes log and exits program
                writing.writeLog(getClass(), " <- EXIT");
                System.exit(0);
            }
        }
    }

    /**
     * Method that hides Mains UI
     */
    public void hideMain(){
        frame.setVisible(false);
    }

    /**
     * Method that shows Mains UI
     */
    public void showMain(){
        frame.setVisible(true);
    }

    /**
     * Main method
     * @param args argument
     */
    public static void main(String[] args) {
        // Clears both files
        errors.clear();
        writing.clear();

        // Writes log
        writing.writeLog(Main.class,"Start program");

        // Starts program
        SwingUtilities.invokeLater(Main::new);
    }
}