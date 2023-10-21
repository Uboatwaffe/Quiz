package org.file.writing;

import org.exceptions.ExceptionUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class that writes log into log.txt
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
        try(PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Backend\\src\\main\\resources\\log.txt", true))){
            out.print(ob.getName() + ":\t");
            out.print(message);
            out.println();
        }catch (IOException e){
            new ExceptionUI(getClass());
        }
    }

    /**
     * Clears whole file
     */
    public void clear(){
        try(PrintWriter out = new PrintWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Backend\\src\\main\\resources\\log.txt")) {
            out.println("");
        }catch(IOException e){
            new ExceptionUI(getClass());
        }
    }
}
