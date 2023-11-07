package org.file;

import org.exceptions.ui.ExceptionUI;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Class that writes log into questions
 * @author Maciej
 * @version 0.1
 */
public class Writing {

    /**
     * Writes into the file
     * @param ob Name of the class
     * @param message Text that will be put into the file
     */
    public void writeLog(Class<?> ob, String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter("Backend\\src\\main\\resources\\log.txt", true))) {
            // Prints name of the class
            out.print(ob.getName() + ": ");

            // Prints the message
            out.print(message);

            // Prints empty line
            out.println();
        } catch (Exception ignore) {
            new ExceptionUI(getClass(), "Couldn't find file or couldn't print anything out");
        }
    }

    /**
     * Clears whole file
     */
    public void clear(){
        try (PrintWriter out = new PrintWriter("Backend\\src\\main\\resources\\log.txt")) {
            // Clears whole file
            out.println("");
        } catch (Exception ignore) {
            new ExceptionUI(getClass(), "Couldn't find file or couldn't print anything out");
        }
    }
}
