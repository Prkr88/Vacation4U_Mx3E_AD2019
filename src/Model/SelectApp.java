package Model;

import View.Main;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Mx3e
 */

public class SelectApp extends SqlApp{


//
//    /**
//     * select all rows in the warehouses table
//     */
//    public void selectAll(){
//        String sql = "SELECT user_name,password,birth_date,private_name,last_name,city_of_origin FROM Users";
//
//        try (Connection conn = this.connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){
//
//            // loop through the result set
//            while (rs.next()) {
//                System.out.println(rs.getString("user_name") +  "\t" +
//                        rs.getString("password") + "\t" +
//                        rs.getString("birth_date") + "\t" +
//                        rs.getString("private_name") + "\t" +
//                        rs.getString("last_name") + "\t" +
//                        rs.getString("city_of_origin"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    /**
     * this function will return data for certain user
     * @param user_name user name desired
     * @return String array with all the relevant data for the user(except password)
     */

    public String[] selectUser(String user_name){
        String[] res = new String[5];
        String sql = "SELECT user_name,birth_date,private_name,last_name,city_of_origin FROM Users WHERE user_name="
                + "'" + user_name + "'";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            res[0] = rs.getString("user_name");
            res[1] = rs.getString("private_name");
            res[2] = rs.getString("last_name");
            res[3] = rs.getString("birth_date");
            res[4] = rs.getString("city_of_origin");
            // loop through the result set
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            int i;
        }
        return null;
    }

    public ArrayList<ArrayList<String>> displayVacation() {
        String thisUser = Main.signedUserName;
        String sql = "SELECT vacation_id FROM OfferedVacations WHERE seller_id=" + "'" + thisUser + "'";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public String[] selectSwapConfirmation() {
        String sql = "SELECT * FROM SwapRequestsVacations WHERE userName_B=" + "'" + Main.signedUserName + "'";
        String[] res = new String[5];
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            res[0] = rs.getString("userName_A");
            res[1] = rs.getString("vID_A");
            res[2] = rs.getString("vID_B");
            res[3] = rs.getString("userName_B");
            res[4] = rs.getString("confirm_A");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            int i;
        }
        return null;
    }

    public String[] selectSwapRequestVacation() {
        String sql = "SELECT * FROM SwapRequestsVacations WHERE userName_A=" + "'" + Main.signedUserName + "'";
        String[] res = new String[5];

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            res[0] = rs.getString("userName_A");
            res[1] = rs.getString("vID_A");
            res[2] = rs.getString("vID_B");
            res[3] = rs.getString("userName_B");
            res[4] = rs.getString("confirm_A");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            int i;
        }
        return null;
    }

    public ArrayList<ArrayList<String>> selectSwapRequests(){
        String sql = "SELECT * FROM OfferedVacations";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public ArrayList<ArrayList<String>> selectSwapVacation(){
        String sql = "SELECT * FROM SwapOfferedVacations";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public String[] selectVacation(String sVacID){
        String[] res = new String[12];
        String user_name = Main.signedUserName;
        String sql = "SELECT vacation_id,destination,price,start_date,end_date,num_adult_tickets,num_kid_tickets,num_baby_tickets,flight_back_included,flight_company,vacation_type,accom_included FROM OfferedVacations WHERE vacation_id="
                + "'" + sVacID + "'";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            res[0] = rs.getString("vacation_id");
            res[1] = rs.getString("destination");
            res[2] = rs.getString("price");
            res[3] = rs.getString("start_date");
            res[4] = rs.getString("end_date");
            res[5] = rs.getString("num_adult_tickets");
            res[6] = rs.getString("num_kid_tickets");
            res[7] = rs.getString("num_baby_tickets");
            res[8] = rs.getString("flight_back_included");
            res[9] = rs.getString("flight_company");
            res[10] = rs.getString("vacation_type");
            res[11] = rs.getString("accom_included");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<ArrayList<String>> selectOfferedVacation(String date1, String date2, String price, String destination) {
        String sql = "SELECT * FROM OfferedVacations WHERE start_date BETWEEN " +
                "'" + date1 + "'" +" AND " + "'" + date2 + "'" +
                " AND end_date BETWEEN " + "'" + date1 + "'" + " AND " +"'" + date2 + "'" ;
        if (!price.equals(""))
            sql = sql + "AND price=" + "'" + price + "'";
        if(!destination.equals(""))
            sql = sql + " AND destination= " + "'" + destination + "'";
        if (date1.equals("--") && date2.equals("--"))
            sql = "SELECT * FROM OfferedVacations";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;

    }

    public ArrayList<ArrayList<String>> selectOfferedVacationById(int vId) {
        String sql = "SELECT * FROM OfferedVacations WHERE vacation_id ="+"'"+Integer.toString(vId)+"'";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public ArrayList<ArrayList<String>> selectVacationRequest(String signdUser) {
        String sql = "SELECT VacationsRequests.vacation_id,VacationsRequests.buyer_id FROM VacationsRequests JOIN OfferedVacations " +
                "On VacationsRequests.vacation_id= OfferedVacations.vacation_id where OfferedVacations.seller_id = " + "'" + signdUser + "'";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public ArrayList<ArrayList<String>> selectApprovePayVacations() {
        String thisUser = Main.signedUserName;
        String sql = "SELECT vacation_id,buyer_id FROM VacationsRequests WHERE accepted_by_seller =1 And seller_id=" + "'" + thisUser + "'";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public ArrayList<ArrayList<String>> selectToPayVacations() {
        String thisUser = Main.signedUserName;
        String sql = "SELECT vacation_id FROM VacationsRequests WHERE accepted_by_seller = 1 AND buyer_id=" + "'" + thisUser + "'";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public ArrayList<ArrayList<String>> selectDeclinedRequests() {
        String thisUser = Main.signedUserName;
        String sql = "SELECT vacation_id,seller_id FROM VacationsRequests WHERE accepted_by_seller = -1 AND buyer_id=" + "'" + thisUser + "'";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public String selectUserByVID(int vID) {
        String userName = "";
        String sql = "SELECT seller_id FROM OfferedVacations WHERE vacation_id=" + vID;
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        if(data.size()>0) {
            userName = data.get(0).get(0);
            return userName;
        }
        else{
            return null;
        }
    }

}