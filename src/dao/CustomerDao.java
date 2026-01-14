package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBConnection;

public class CustomerDao {

    public void insertCustomer(String name, String email, String contact,
                               String aadhar, int accNo) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "INSERT INTO customers(name,email,contact,aadhar,account_number) VALUES (?,?,?,?,?)")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, contact);
            ps.setString(4, aadhar);
            ps.setInt(5, accNo);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
