package database;

import entities.Entry;
import json.JsonWriter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/blog";
    private Connection con;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;

    public Connection getConnectionInstance() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*public static void main(String[] args) {
        DBConnector db = new DBConnector();
        System.out.println(JsonWriter.returnEntryListJson(db.getAllEntries()));
    }*/
}
