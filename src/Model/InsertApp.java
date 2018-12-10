package Model;

import View.Main;

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

    public void insertVacation(int iAdultAmount, int iChildAmount, int iBabyAmount, int iTotalPrice, String strDestination, String strAirline, String strDepDate, String strArrivalDate, String strVacType, String sLodge, String sReturn, String strLuggageDetails) {

        String sql = "INSERT INTO OfferedVacations(iAdultAmount,iChildAmount,iBabyAmount,iTotalPrice,strDestination,strAirline,strDepDate,strArrivalDate,boolLodge,boolReturnFlight,strLuggageDetails) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //NOTE: validate that VACATION ID is inserted automatically
            pstmt.setString(2, Main.signedUserName);
            pstmt.setString(3, strDepDate);
            pstmt.setString(4, strArrivalDate);
            pstmt.setString(5, iAdultAmount +"");
            pstmt.setString(6, iChildAmount+ "");
            pstmt.setString(7, iBabyAmount+ "");
            pstmt.setString(8, strAirline);
            pstmt.setString(9, strVacType);
            pstmt.setString(10, sLodge);
            pstmt.setString(11, strDestination);
            pstmt.setString(12, sReturn);
            pstmt.setString(13, iTotalPrice +"");
            pstmt.setString(14, strLuggageDetails);
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