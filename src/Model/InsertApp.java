package Model;

import java.sql.*;

/**
 *
 * @author Mx3E
 */
public class InsertApp extends SqlApp{

    /**inserts new user to Users Table
     * @param userName user name
     * @param password password
     * @param bDate birth date
     * @param pName person name
     * @param lName last name
     * @param city city of origin
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