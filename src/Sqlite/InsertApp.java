package Sqlite;

import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp extends SqlApp{

    /**inserts new user to Users Table
     * @param userName
     * @param password
     * @param bDate
     * @param pName
     * @param lName
     * @param city
     */
    public void insert(String userName ,String password,String bDate,String pName,String lName,String city) {
        String sql = "INSERT INTO Users(user_name,password,birth_date,private_name,last_name,city_of_origin) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, bDate);
            pstmt.setString(4, pName);
            pstmt.setString(5, lName);
            pstmt.setString(6, city);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}