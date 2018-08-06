package database;

import java.sql.*;

public class LoginDao {
    public static boolean validate(String email, String password) {
        boolean status = false;
        DBConnector connector = new DBConnector();
        Connection con = connector.getConnectionInstance();
        String sql = "SELECT * FROM schema1.users WHERE email=? AND password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status;
    }
}
