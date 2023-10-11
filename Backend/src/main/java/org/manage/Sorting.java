package org.manage;

import org.connecting.Connect;
import org.exceptions.ExceptionUI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sorting {
    public void sort(){
        try {
            Connect connect = new Connect();
            HowMany howMany = new HowMany();

            ResultSet resultSet = connect.getConnection();

            String[] questions = new String[howMany.howMany()];
            String[] answers = new String[howMany.howMany()];
            String[] types = new String[howMany.howMany()];

            int i = 0;

            while(resultSet.next()){
                questions[i] = resultSet.getString("question");
                answers[i] = resultSet.getString("answer");
                types[i++] = resultSet.getString("type");
            }


            Deleting.delete("-1");

            for (int j = 0; j < i; j++) {
                Adding.add(questions[j], answers[j], types[j]);
            }
        }catch (SQLException ignore){
            new ExceptionUI();
        }
    }
}
