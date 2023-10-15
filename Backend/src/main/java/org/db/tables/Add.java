package org.db.tables;

import org.db.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Maciej
 * @version 0.1
 */
public class Add {
    private static final Writing writing = new Writing();


    /**
     * Method that adds new table to the DB
     * @param name Name of the new table
     */
    public static void add(String name){

        try {
            writing.writeLog(Add.class, "Adding tables");


            String sql = "CREATE TABLE `quiz`.`"+ name +"` (`id` INT NOT NULL,`question` VARCHAR(90) NOT NULL,`answer` VARCHAR(45) NOT NULL,`type` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`))";
            String sql2 = "INSERT INTO tables VALUES ('"+ name +"')";
            String sql3 = "INSERT INTO score VALUES ('"+ name +"', '"+ 0 +"', '"+ 0 +"', '"+ 0 +"')";

            PreparedStatement statement2 = Connecting.getConnection().prepareStatement(sql);
            statement2.executeUpdate();

            PreparedStatement statement3 = Connecting.getConnection().prepareStatement(sql2);
            statement3.executeUpdate();

            PreparedStatement statement4 = Connecting.getConnection().prepareStatement(sql3);
            statement4.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(Add.class);
        }
    }
}
