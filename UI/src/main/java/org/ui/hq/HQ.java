package org.ui.hq;

import org.connecting.Connect;
import java.sql.*;
import org.exceptions.ExceptionUI;
import org.ui.questions.*;

public class HQ extends Thread{
    // Class that has its own Thread - responsible for showing questions to user
    private final Connect connect = new Connect();

    public void start(){
        try {
            ResultSet resultSet = connect.getConnection();
            if (resultSet != null) {
                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    switch(type){
                        case "d" -> new QuestionDate(resultSet.getString("question"), resultSet.getString("answer"));
                        case "c" -> new QuestionABC(resultSet.getString("question"), resultSet.getString("answer"));
                        case "o" -> new QuestionOpen(resultSet.getString("question"), resultSet.getString("answer"));
                        case "t" -> new QuestionTrueOrFalse(resultSet.getString("question"), resultSet.getString("answer"));
                    }
                }
            }
        }catch (SQLException ignored){
            new ExceptionUI();
        }
    }
}
