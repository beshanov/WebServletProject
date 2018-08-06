package database;

import entities.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntryDao {
    DBConnector connector = new DBConnector();

    private Connection con;
    private Statement stmt;
    private PreparedStatement ps;
    private ResultSet rs;

    public void addEntry(String data) {
        data = data != null ? data : "";
        try{
            con = connector.getConnectionInstance();
            String sql = "INSERT INTO schema1.blog (data, created) VALUES (?, now())";
            ps = con.prepareStatement(sql);
            ps.setString(1, data);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Entry> getAllEntries() {
        List<Entry> entries = new ArrayList<Entry>();
        con = connector.getConnectionInstance();
        String sql = "SELECT data, created, entry_id FROM schema1.blog ORDER BY created DESC";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setData(rs.getString("data"));
                entry.setCreated(rs.getString("created").substring(0,16));
                entry.setId(rs.getInt("entry_id"));
                entries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return entries;
        }
    }
}
