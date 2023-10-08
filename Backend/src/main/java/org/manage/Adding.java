package org.manage;

import org.connecting.Connecting;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Adding {
    static HowMany howMany = new HowMany();
    public static void add(String question, String answer, String type) {
        String SQL = "INSERT INTO set1 VALUES ('"+ howMany.howMany()+1 +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    public static void add(String index, String question, String answer, String type) {
        String SQL = "INSERT INTO set1 VALUES ('"+ index +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}