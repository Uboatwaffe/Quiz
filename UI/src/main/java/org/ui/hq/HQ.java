package org.ui.hq;

import org.connecting.Connect;
import java.sql.*;
import org.exceptions.CustomException;
import org.exceptions.ExceptionUI;
import org.ui.questions.*;
import org.ui.score.Score;

public class HQ extends Thread{
    Connect connect = new Connect();

    String type;
    public void start(){
        try {
            ResultSet resultSet = connect.getConnection();
            if (resultSet != null) {
                while (resultSet.next()) {
                    type = resultSet.getString("type");
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
