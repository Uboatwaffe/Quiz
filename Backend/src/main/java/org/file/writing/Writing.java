package org.file.writing;

import org.exceptions.ExceptionUI;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writing {


    public void writeLog(Class ob, String message) throws IOException {
        try(PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Backend\\src\\main\\resources\\log.txt", true))){
            out.print(ob.getName() + ": ");
            out.print(message);
            out.println();
        }catch (IOException e){
            new ExceptionUI();
        }
    }

    public void clear(){
        try(PrintWriter out = new PrintWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Backend\\src\\main\\resources\\log.txt")) {
            out.println("");
        }catch(IOException e){
            new ExceptionUI();
        }
    }
}
