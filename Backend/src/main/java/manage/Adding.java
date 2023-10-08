package manage;

import org.connecting.Connecting;
import org.connecting.HowMany;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Adding {
    static HowMany howMany = new HowMany();
    public static void add(String question, String answer, String type) {
        String SQL = "INSERT INTO set1 VALUES ('"+ howMany.howMany() +"', '"+ question +"', '"+ answer +"', '"+ type +"');";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }


    }
}
