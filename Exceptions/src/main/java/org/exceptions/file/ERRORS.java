package org.exceptions.file;

import org.exceptions.ui.ExceptionUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class that writes into different file (errors.txt) classes that thrown ExceptionUI
 * @author Maciej
 * @version 0.1
 */
public class ERRORS {

    /**
     * Writes who thrown ExceptionUI
     * @param ob Name of the class that thrown ExceptionUI
     * @param message Message that will be written
     */
    public void writeLog(Class<?> ob, String message) {
        try(PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Exceptions\\src\\main\\resources\\errors.txt", true))){
            // Writes class name
            out.print(ob.getName() + ":\t");

            // Writes message
            out.print(message);

            // Writes empty line
            out.println();
        }catch (IOException e){
            new ExceptionUI(getClass());
        }
    }

    /**
     * Clears whole file
     */
     public void clear(){
        try(PrintWriter out = new PrintWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Exceptions\\src\\main\\resources\\errors.txt")) {

            // Clears whole file
            out.println("");
        }catch(IOException e){
            new ExceptionUI(getClass());
        }
    }
}
