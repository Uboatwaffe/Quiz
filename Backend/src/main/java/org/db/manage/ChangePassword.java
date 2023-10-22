package org.db.manage;

import org.db.connecting.Connection;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class responsible for changing login and password
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public class ChangePassword {

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();

    /**
     * Method that changes login and password
     * @param login New login
     * @param password New password
     * @param user Name of the user that is logged in
     */
    public static void change(String login, String password, String user){
        // Query
        String SQL = "UPDATE `admin` SET `login` = '"+ login +"', `password` = '"+ password +"' WHERE (`user` = '"+ user +"')";
        try {
            // Writes log
            writing.writeLog(ChangePassword.class, "Updating admin details");

            // Executes query
            PreparedStatement statement = Connection.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        }catch (SQLException | NullPointerException ignore){
            writing.writeLog(Deleting.class, " -> ExceptionUI");
            new ExceptionUI(ChangePassword.class);
        }
    }
}
