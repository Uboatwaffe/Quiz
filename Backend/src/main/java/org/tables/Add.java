package org.tables;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.manage.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {
    public static void add(String name){
        ResultSet resultSet;

        try {
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
            new ExceptionUI();
        }
    }
}
