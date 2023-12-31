package org.db.manage;

import org.annotation.DataBase;
import org.db.connecting.Connection;
import org.exceptions.ui.ExceptionUI;
import org.file.Writing;

import java.sql.PreparedStatement;

/**
 * Class responsible for changing login and password
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
@DataBase
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
        } catch (Exception ignore) {
            writing.writeLog(Deleting.class, " -> ExceptionUI");
            new ExceptionUI(ChangePassword.class, "Something went wrong when inserting new values into the database");
        }
    }
}
