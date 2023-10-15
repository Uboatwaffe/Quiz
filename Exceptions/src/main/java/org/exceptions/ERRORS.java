package org.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ERRORS {
    @SuppressWarnings("SpellCheckingInspection")
    public void writeLog(@SuppressWarnings("rawtypes") Class ob, String message) {
        try(PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Exceptions\\src\\main\\resources\\errors.txt", true))){
            out.print(ob.getName() + ":\t");
            out.print(message);
            out.println();
        }catch (IOException e){
            new ExceptionUI(getClass());
        }
    }

     @SuppressWarnings("SpellCheckingInspection")
     public void clear(){
        try(PrintWriter out = new PrintWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Exceptions\\src\\main\\resources\\errors.txt")) {
            out.println("");
        }catch(IOException e){
            new ExceptionUI(getClass());
        }
    }
}
