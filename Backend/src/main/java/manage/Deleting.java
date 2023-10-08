package manage;
import org.connecting.Connecting;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deleting {

    public static void delete(String index) {
        String SQL = "DELETE FROM set1 WHERE id='" + index +"'";

        try {
            PreparedStatement statement = Connecting.getConnection().prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }

    }
}
