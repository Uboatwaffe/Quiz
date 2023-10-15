package org.db.manage;

import org.db.connecting.Connecting;
import org.exceptions.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class responsible for adding new log.txt to database
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public class Adding {
    private static final HowMany howMany = new HowMany();
    private static final Writing writing = new Writing();

    /**
     * Inserts question with all additional info into DB
     * @param question Question that will be inserted into DB
     * @param answer Answer to that question
     * @param type Type of this question ('c' || 'o' || 'd' || 't')
     */
    @SuppressWarnings("DataFlowIssue")
    public static void add(String question, String answer, String type) {
        // Query
        String sql = "INSERT INTO "+ SQL.getCurrentTable() + " VALUES ('"+ (howMany.highest() + 1) +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            writing.writeLog(Adding.class, "Adding questions");
            // Executing query
            PreparedStatement statement = Connecting.getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(Adding.class);
        }
    }

}