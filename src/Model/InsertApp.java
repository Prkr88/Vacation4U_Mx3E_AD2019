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
    public void insertUser(String userName , String password, String bDate, String pName, String lName, String city) {
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

    /**inserts new user to Users Table
     * @param vacationID vacationID Requested
     * @param userID userID of the user requested
     */
    public void insertVacationRequest(int vacationID , String userID) {
        String sql = "INSERT INTO VacationsRequests(vacation_id,user_id) VALUES(?,?)";
        if(vacationRequestQueue(vacationID)<20) {
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, vacationID);
                pstmt.setString(2, userID);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Cannot add more requests for this Vacation.");
        }
    }

    public int vacationRequestQueue(int vacationID){
        int res = 0;
        String sql = "SELECT COUNT (vacation_id) AS total FROM VacationsRequests WHERE vacation_id="+ "'" + vacationID + "'";
        int ans = 0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             res = rs.getInt("total");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }


}