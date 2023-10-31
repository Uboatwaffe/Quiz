package org.db.reset;

import org.db.manage.Adding;
import org.db.manage.ChangePassword;
import org.db.manage.Deleting;
import org.db.manage.SQL;
import org.db.tables.Delete;
import org.file.Writing;

/**
 * Class that stores all default data
 * @author Maciej
 * @version 0.1
 */
public class Reset {

    /**
     * Field that stores all tables names
     */
    private static final String[] tableNames = SQL.getAllTables();

    /**
     *  Field that stores default questions
     */
    private static final String[] db1 = {"True or False", "Close question", "Open question", "Question about date"};

    /**
     * Field that stores default answers
     */
    private static final String[] db2 = {"TRUE", "A", "YES", "11.11.1111"};

    /**
     * Field that stores default types of questions
     */
    private static final String[] db3 = {"t", "c", "o", "d"};

    /**
     * Object used to write log
     * @see Writing
     */
    private static final Writing writing = new Writing();


    /**
     * Method that resets whole configuration
     */
    public static void reset() {
        // Writes log
        writing.writeLog(Reset.class, "Reseting");

        // Creates array in the size of all tables-1
        String[] toDelete = new String[tableNames.length-1];
        int i = 0;

        /*
        Puts every table in 'toDelete' except 'set1'
        This never allows for empty DB
         */
        for (String x:
             tableNames) {
            if(!x.equals("set1")){
                toDelete[i++] = x;
            }
        }

        writing.writeLog(Reset.class, " -> SQL");

        // Sets current table to 'set1' (it is always under 0 index)
        SQL.setCurrentTable(SQL.getAllTables()[0]);

        writing.writeLog(Reset.class, " -> Deleting");
        // Clears 'set1' from all questions
        Deleting.delete("-1");

        writing.writeLog(Reset.class, " -> Adding");
        // Adds default questions
        for (int j = 0; j < db1.length; j++) {
            Adding.add(db1[j], db2[j], db3[j]);
        }

        writing.writeLog(Reset.class, " -> Delete");

        // Deletes other tables
        for (String x:
             toDelete) {
            Delete.delete(x);
        }

        writing.writeLog(Reset.class, " -> ChangePassword");

        // Changes password and login to default ones
        ChangePassword.change("Login", "Password", "admin");
    }

}
