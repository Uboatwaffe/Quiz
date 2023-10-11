package org.manage;

import org.connecting.Connecting;
import org.exceptions.ExceptionUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    private static String currentTable = getAllTables()[0];

    public static void setCurrentTable(String currentTable) {
        SQL.currentTable = currentTable;
    }

    public static String getCurrentTable() {
        return currentTable;
    }

    public static String[] getAllTables(){
        // Returns all tables existing in DB

        String[] db = {"set1"};
        try {
            Statement statement = Connecting.getConnection().createStatement();

            assert statement != null;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tables");

            int i = 0;
            while (resultSet.next()) i++;

            db = new String[i];

            resultSet = statement.executeQuery("SELECT * FROM tables");
             i = 0;
            while (resultSet.next()){
                db[i++] = resultSet.getString("name");
            }

        }catch (SQLException ignore){
            new ExceptionUI();
        }
        return db;
    }
}
