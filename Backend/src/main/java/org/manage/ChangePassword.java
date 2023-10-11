package org.manage;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePassword {
    private final Connecting connecting = new Connecting();
    public static void change(String login, String password, String user){
        String SQL = "UPDATE `admin` SET `login` = '"+ login +"', `password` = '"+ password +"' WHERE (`user` = '"+ user +"')";
        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        }catch (SQLException ignore){
            new ExceptionUI();
        }
    }
}
