package database;

import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    DBConnector connector = new DBConnector();

    private Connection con;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        con = connector.getConnectionInstance();
        String sql = "SELECT name, email, password, user_id FROM schema1.users";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("user_id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            rs.close();
            stmt.close();
            con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    public void addUser(String name, String email, String password) {
        con = connector.getConnectionInstance();
        String sql = "INSERT INTO schema1.users (name, email, password) VALUES(?, ?, ?)";
        try {
        ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.executeQuery();
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
    }


    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.getAllUsers());
        userDao.addUser("ivanov", "ivanov@mail.ru", "passwd");
        System.out.println(userDao.getAllUsers());
    }
}

