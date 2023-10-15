package org.db.manage;

import org.db.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class responsible for changing login and password
 * @author Maciej
 * @version 0.1
 */
public class ChangePassword {
    private final Connecting connecting = new Connecting();
    private static final Writing writing = new Writing();

    /**
     * Method that changes login 'n' password
     * @param login New login
     * @param password New password
     * @param user Name of the user that is logged in
     */
    public static void change(String login, String password, String user){
        // Query
        String SQL = "UPDATE `admin` SET `login` = '"+ login +"', `password` = '"+ password +"' WHERE (`user` = '"+ user +"')";
        try {
            writing.writeLog(ChangePassword.class, "Updating admin details");
            // Executing query
            PreparedStatement statement = Connecting.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        }catch (SQLException | IOException ignore){
            new ExceptionUI(ChangePassword.class);
        }
    }
}
