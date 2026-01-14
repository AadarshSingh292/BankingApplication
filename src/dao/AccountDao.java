package dao;

import java.sql.*;
import util.DBConnection;

public class AccountDao {

    public boolean accountExists(int accNo) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT 1 FROM aacounts WHERE account_number=?")) {

            ps.setInt(1, accNo);
            return ps.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public double getBalance(int accNo) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT balance FROM aacounts WHERE account_number=?")) {

            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateBalance(int accNo, double newBalance) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "UPDATE aacounts SET balance=? WHERE account_number=?")) {

            ps.setDouble(1, newBalance);
            ps.setInt(2, accNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAccount(int accNo) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "INSERT INTO aacounts VALUES (?,0)")) {

            ps.setInt(1, accNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllAccounts() {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT * FROM aacounts");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("account_number") +
                        " | Balance: " +
                        rs.getDouble("balance")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
