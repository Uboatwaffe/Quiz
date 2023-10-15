package org.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ERRORS {
    void writeLog(Class ob, String message) throws IOException {
        try(PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Exceptions\\src\\main\\resources\\errors.txt", true))){
            out.print(ob.getName() + ":\t");
            out.print(message);
            out.println();
        }catch (IOException e){
            new ExceptionUI(getClass());
        }
    }

     void clear(){
        try(PrintWriter out = new PrintWriter("C:\\Users\\PC\\Desktop\\Maciek\\JavaProfesional\\Quiz\\Backend\\src\\main\\resources\\log.txt")) {
            out.println("");
        }catch(IOException e){
            new ExceptionUI(getClass());
        }
    }
}
