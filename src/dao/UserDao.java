package dao;

import java.sql.*;
import model.User;
import util.DBConnection;

public class UserDao {

    public User login(String username, String password) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT * FROM users WHERE username=? AND password=?")) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("account_number")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 🔹 Check if login already exists for account
    public boolean userExistsForAccount(int accNo) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT 1 FROM users WHERE account_number=?")) {

            ps.setInt(1, accNo);
            return ps.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔹 Create user login
    public void createUser(String username, String password, int accNo) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "INSERT INTO users(username,password,role,account_number) VALUES (?,?,?,?)")) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, "USER");
            ps.setInt(4, accNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
