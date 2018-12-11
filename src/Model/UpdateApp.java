package Model;

import View.Main;

import java.sql.*;

/**
 *
 * @author Mx3e
 */
public class UpdateApp extends SqlApp {

    /**
     * current users password
     */
    private String thisPass;
    /**
     * current users birth date
     */
    private String thisBirth;
    /**
     * current users person name
     */
    private String thisPName;
    /**
     * current users Last name
     */
    private String thisLName;
    /**
     * current users city of origin
     */
    private String thisCity;

    /**
     * this function updates user data
     *
     * @param userName user name
     * @param password password
     * @param bDate    birth date
     * @param pName    person name
     * @param lName    last name
     * @param city     city of origin
     */
    public void updateUser(String userName, String password, String bDate, String pName, String lName, String city) {

        String sqlRetrieve = "SELECT user_name,password,birth_date,private_name,last_name,city_of_origin FROM Users WHERE user_name = " + "'" + Main.signedUserName + "'";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlRetrieve)) {
            thisPass = rs.getString("password");
            thisBirth = rs.getString("birth_date");
            thisPName = rs.getString("private_name");
            thisLName = rs.getString("last_name");
            thisCity = rs.getString("city_of_origin");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sqlSet = "UPDATE Users SET " +
                "password = ? ," +
                "birth_date = ?," +
                "private_name = ?," +
                "last_name = ?," +
                " city_of_origin = ? "
                + "WHERE user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlSet)) {
            // set the corresponding param
            if (!password.equals(""))
                pstmt.setString(1, password);
            else
                pstmt.setString(1, thisPass);
            if (!bDate.equals(""))
                pstmt.setString(2, bDate);
            else
                pstmt.setString(2, thisBirth);
            if (!pName.equals(""))
                pstmt.setString(3, pName);
            else
                pstmt.setString(3, thisPName);
            if (!lName.equals(""))
                pstmt.setString(4, lName);
            else
                pstmt.setString(4, thisLName);
            if (!city.equals(""))
                pstmt.setString(5, city);
            else
                pstmt.setString(5, thisCity);
            pstmt.setString(6, Main.signedUserName);
            // update Parameters
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void updateVacation(int vacationID, int numAdultTickets, int numKidTickets, int numBabyTickets, int totalPrice, String destination, String flightCompany, String startDate, String endDate, String vacationType, String accommodationIncluded, String flightBackIncluded, String sLuggageDetails) {
        String oldStartDate = "";
        String oldEndDate = "";
        int oldNumAdult = 0;
        int oldNumKid = 0;
        int oldNumBaby = 0;
        String oldDestination = "";
        String oldFlightCompany = "";
        String oldVacType = "";
        int oldAccomIncluded = 0;
        int oldFlightBackIncluded = 0;
        int oldPrice = 0;
        String oldLuggage = "";
        String sqlRetrieve = "SELECT * FROM OfferedVacations WHERE seller_id = " + "'" + Main.signedUserName + "'" + "AND vacation_id=" + "'" + vacationID + "'";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlRetrieve)) {
            oldStartDate = rs.getString("start_date");
            oldEndDate = rs.getString("end_date");
            oldNumAdult = rs.getInt("num_adult_tickets");
            oldNumKid = rs.getInt("num_kid_tickets");
            oldNumBaby = rs.getInt("num_baby_tickets");
            oldDestination = rs.getString("destination");
            oldFlightCompany = rs.getString("flight_company");
            oldVacType = rs.getString("vacation_type");
            oldAccomIncluded = rs.getInt("accom_included");
            oldFlightBackIncluded = rs.getInt("flight_back_included");
            oldPrice = rs.getInt("price");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sqlSet = "UPDATE OfferedVacations SET " +
                "start_date = ? ," +
                "end_date = ?," +
                "num_adult_tickets = ?," +
                "num_kid_tickets = ?," +
                "num_baby_tickets = ? ," +
                "destination = ? ," +
                "flight_company = ? ," +
                "vacation_type = ? ," +
                "accom_included = ? ," +
                "flight_back_included = ? ," +
                "price = ? "
                + "WHERE seller_id = ? AND vacation_id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlSet)) {
            // set the corresponding param
            if (!startDate.equals(""))
                pstmt.setString(1, startDate);
            else
                pstmt.setString(1, oldStartDate);
            if (!endDate.equals(""))
                pstmt.setString(2, endDate);
            else
                pstmt.setString(2, oldEndDate);
            if (numAdultTickets != -1)
                pstmt.setInt(3, numAdultTickets);
            else
                pstmt.setInt(3, oldNumAdult);
            if (numKidTickets != -1)
                pstmt.setInt(4, numKidTickets);
            else
                pstmt.setInt(4, oldNumKid);
            if (numBabyTickets != -1)
                pstmt.setInt(5, numBabyTickets);
            else
                pstmt.setInt(5, oldNumBaby);
            if (!destination.equals(""))
                pstmt.setString(6, destination);
            else
                pstmt.setString(6, oldDestination);
            if (!flightCompany.equals(""))
                pstmt.setString(7, flightCompany);
            else
                pstmt.setString(7, oldFlightCompany);
            if (!vacationType.equals(""))
                pstmt.setString(8, vacationType);
            else
                pstmt.setString(8, oldVacType);
            if (accommodationIncluded != null)
                pstmt.setString(9, accommodationIncluded);
            else
                pstmt.setInt(9, oldAccomIncluded);
            if (flightBackIncluded != null)
                pstmt.setString(10, flightBackIncluded);
            else
                pstmt.setInt(10, oldFlightBackIncluded);
            if (totalPrice != -1)
                pstmt.setInt(11, totalPrice);
            else
                pstmt.setInt(11, oldPrice);
            pstmt.setString(12, View.Main.signedUserName);
            pstmt.setInt(13, vacationID);
            // update Parameters
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAcceptedBySeller(int vacationID, String sellerID) {
        String sql = "UPDATE VacationsRequests SET accepted_by_seller = ? WHERE vacation_id = " +
                "'" + vacationID + "' AND seller_id = " + "'" + sellerID + "'";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


//    public static void main(String[] args) {
//        UpdateApp uA = new UpdateApp();
//        uA.updateAcceptedBySeller(1, "Matan");
//    }


}