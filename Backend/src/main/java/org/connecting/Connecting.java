package org.connecting;

import org.exceptions.ExceptionUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connecting {
    public static Connection getConnection() {
        try {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "password");
        }catch (SQLException ignore){
            new ExceptionUI();
        }
        return null;
    }
}
