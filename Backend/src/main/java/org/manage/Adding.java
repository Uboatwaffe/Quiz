package org.manage;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Adding {
    private static final HowMany howMany = new HowMany();
    public static void add(String question, String answer, String type) {
        String sql = "INSERT INTO "+ SQL.getCurrentTable() + " VALUES ('"+ String.valueOf(howMany.highest()+1) +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI();
        }
    }
    public static void add(String index, String question, String answer, String type) {
        String sql = "INSERT INTO "+ SQL.getCurrentTable() +" VALUES ('"+ index +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI();
        }
    }
}