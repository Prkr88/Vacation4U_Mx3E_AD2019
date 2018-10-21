package Sqlite;

import java.sql.*;

public class UpdateApp extends SqlApp{


    public void updateUser(String userName ,String password,String bDate,String pName,String lName,String city) {
        String sql = "UPDATE Users SET " +
                "password = ? ," +
                "birth_date = ?," +
                "private_name = ?," +
                "last_name = ?," +
                " city_of_origin = ? "
                + "WHERE user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, password);
            pstmt.setString(2, bDate);
            pstmt.setString(3, pName);
            pstmt.setString(4, lName);
            pstmt.setString(5, city);
            pstmt.setString(6, userName);
            // update Parmeters
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}