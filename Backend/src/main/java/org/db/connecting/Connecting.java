package org.db.connecting;

import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for establishing connection with database
 * @author Maciej
 * @version 0.1
 */
public final class Connecting {
    private static final Writing writing = new Writing();

    /**
     * @return Connection reference to database
     */
    public static Connection getConnection() {
        writing.writeLog(Connecting.class, "Establishing connection to DB");
        try {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "password");
        }catch (SQLException ignore){
            new ExceptionUI(Connecting.class);
        }
        return null;
    }
}
