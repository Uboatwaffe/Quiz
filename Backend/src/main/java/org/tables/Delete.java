package org.tables;

import org.connecting.Connecting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    ResultSet resultSet;
    public static void delete(String name){

        try {

        String sql = "DROP TABLE `quiz`.`"+ name +"`;";
        String sql2 = "DELETE FROM `quiz`.`tables` WHERE (`name` = '"+ name +"');";
        String sql3 = "DELETE FROM `quiz`.`score` WHERE (`name` = '"+ name +"');";


        PreparedStatement statement2 = Connecting.getConnection().prepareStatement(sql);
        statement2.executeUpdate();

        PreparedStatement statement3 = Connecting.getConnection().prepareStatement(sql2);
        statement3.executeUpdate();

        PreparedStatement statement4 = Connecting.getConnection().prepareStatement(sql3);
        statement4.executeUpdate();
    } catch (SQLException | NullPointerException e) {
        throw new RuntimeException(e);
    }
}
}