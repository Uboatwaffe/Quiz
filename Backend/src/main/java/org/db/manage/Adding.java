package org.db.manage;

import org.db.connecting.Connection;
import org.exceptions.ui.ExceptionUI;
import org.file.writing.Writing;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class responsible for adding new questions to database
 * @author Maciej
 * @version 0.1
 */
@SuppressWarnings("DataFlowIssue")
public final class Adding{

    /**
     * Object used to getting info about number of records in DB
     * @see HowMany
     */
    private static final HowMany howMany = new HowMany();

    /**
     * Object used to write log
     * @see Writing
     */
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
            // Writes log
            writing.writeLog(Adding.class, "Adding questions");

            // Prepares query
            PreparedStatement statement = Connection.getConnection().prepareStatement(sql);

            // Executes query
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            new ExceptionUI(Adding.class);
        }
    }

}