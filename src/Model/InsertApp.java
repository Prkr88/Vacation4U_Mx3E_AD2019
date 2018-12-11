package Model;

import View.Main;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String sqlRead = "SELECT * FROM OfferedVacations ORDER BY vacation_id DESC LIMIT 1";
        String thisID = null;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sqlRead)){
            thisID = rs.getString("vacation_id");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        int last_id;
        if (thisID != null)
            last_id = Integer.parseInt(thisID)+1;
        else
            last_id = 1;
        String sql = "INSERT INTO OfferedVacations(vacation_id,seller_id,start_date,end_date,num_adult_tickets,num_kid_tickets,num_baby_tickets,flight_company,vacation_type,accom_included,destination,flight_back_included,price,luggage_details) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //NOTE: validate that VACATION ID is inserted automatically
            pstmt.setString(1, last_id + "");
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

    public void addSoldVacation(int vacationID, String buyerID, String sellerID, int price) {
        String pattern = "dd-MM-yyyy";
        String dateInString =new SimpleDateFormat(pattern).format(new Date());
        String sql = "INSERT INTO SoldVacations(vacation_id,buyer_id,seller_id,date,price) VALUES(?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vacationID);
            pstmt.setString(2, buyerID);
            pstmt.setString(3, sellerID);
            pstmt.setString(4, dateInString);
            pstmt.setInt(5, price);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
//    public static void main(String args[]) {
//        InsertApp insertApp = new InsertApp();
//        insertApp.addSoldVacation(1, "Matan", "Maytal", 20);
//    }
}