package org.db.manage;

import org.db.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class responsible for adding new log.txt to database
 * @author Maciej
 * @version 0.1
 */
public class Adding {
    private static final HowMany howMany = new HowMany();
    private static final Writing writing = new Writing();

    /**
     * Inserts question with all additional info into DB
     * @param question Question that will be inserted into DB
     * @param answer Answer to that question
     * @param type Type of this question ('c' || 'o' || 'd' || 't')
     */
    public static void add(String question, String answer, String type) {
        // Query
        String sql = "INSERT INTO "+ SQL.getCurrentTable() + " VALUES ('"+ String.valueOf(howMany.highest()+1) +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            writing.writeLog(Adding.class, "Adding questions");
            // Executing query
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException | IOException e) {
            new ExceptionUI(Adding.class);
        }
    }

    /**
     * Inserts question with all additional info into DB
     * @param question Question that will be inserted into DB
     * @param answer Answer to that question
     * @param type Type of this question ('c' || 'o' || 'd' || 't')
     * @param index Index of the question
     */
    public static void add(String index, String question, String answer, String type) {
        // Query
        String sql = "INSERT INTO "+ SQL.getCurrentTable() +" VALUES ('"+ index +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            writing.writeLog(Adding.class, "Adding questions v2");
            // Executing query
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException | IOException e) {
            new ExceptionUI(Adding.class);
        }
    }
}