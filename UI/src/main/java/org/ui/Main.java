package org.ui;

import org.exceptions.file.ERRORS;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;
import org.ui.swing.MainSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main implements ActionListener {

    /**
     * Object used to write log
     * @see Writing
     */
    private final static Writing writing = new Writing();

    /**
     * Frame
     */
    private static final JFrame frame = new JFrame("Quiz");

    /**
     * Object used to write error log
     * @see ERRORS
     */
    private final static ERRORS errors = new ERRORS();

    /**
     * Constructor
     */
    Main() {
        // Default settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,170);
        frame.setLayout(null);

        // Writing log
        writing.writeLog(Main.class, "Showing two options");

        // Labels
        JLabel welcome = new JLabel("Welcome to the quiz!");
        welcome.setBounds(5, 5, 150, 15);

        JLabel question = new JLabel("Which type of it do");
        question.setBounds(5, 30, 300, 15);

        JLabel question2 = new JLabel("you prefer?");
        question2.setBounds(5, 55, 130, 15);

        // Buttons
        JButton swing = new JButton("SWING ONE");
        JButton website = new JButton("WEBSITE ONE");
        JButton close = new JButton("CLOSE");

        swing.setBounds(150, 5, 120, 120);
        website.setBounds(285, 5, 120, 120);
        close.setBounds(5, 80, 130, 45);

        // Adding action listeners
        swing.addActionListener(this);
        website.addActionListener(this);
        close.addActionListener(this);

        // Adding to the frame
        frame.add(website);
        frame.add(welcome);
        frame.add(question);
        frame.add(question2);
        frame.add(swing);
        frame.add(close);

        // Setting visibility
        frame.setVisible(true);
    }

    /**
     * Method that opens index.html in browser
     *
     * @param url path to the website
     * @throws IOException throws when error occurs
     */
    public static void openInBrowser(String url) throws IOException {
        File htmlFile = new File(url);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }

    /**
     * Method that shows menu
     */
    public static void showMain() {
        frame.setVisible(true);
    }

    /**
     * Main method
     *
     * @param args argument required for work
     */
    public static void main(String[] args) {
        // Clears both files
        errors.clear();
        writing.clear();
        writing.writeLog(Main.class, "Starting program");
        SwingUtilities.invokeLater(Main::new);

    }

    /**
     * Method that processes what to do
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SWING ONE" -> {
                writing.writeLog(Main.class, " -> MainSwing");
                new MainSwing();
                hideMain();
            }
            case "WEBSITE ONE" -> {
                writing.writeLog(Main.class, " -> index.html");
                try {
                    openInBrowser("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfessional\\Quiz\\UI\\src\\main\\java\\org\\ui\\website\\index.html");
                } catch (Exception ignore) {
                    new ExceptionUI(Main.class);
                }
            }
            case "CLOSE" -> {
                writing.writeLog(Main.class, " <- EXIT");
                System.exit(0);
            }
        }
    }

    /**
     * Method that hides menu
     */
    public void hideMain(){
        frame.setVisible(false);
    }
}
