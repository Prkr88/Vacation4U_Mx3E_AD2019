package Model;

import View.Main;

import java.sql.*;


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

    public String[][] displayVacation() {
        String[][] res = new String[2][3];
        String thisUser = Main.signedUserName;
        String sqlRead = "SELECT vacation_id FROM OfferedVacations WHERE seller_id=" +"'" + thisUser + "'";
        int i = 0;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sqlRead)) {
            while (i < 3) {
                res[0][i] = rs.getString("vacation_id");
                res[1][i] = rs.getString("destination");
                i++;
            }
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public String[] selectVacation(String destination){
        String[] res = new String[5];
        String user_name = Main.signedUserName;
        String sql = "SELECT vacation_id,destination,price,start_date,end_date,num_adult_tickets,num_kid_tickets,num_baby_tickets,flight_back_included,flight_company,vacation_type,accom_included FROM OfferedVacations WHERE destination="
                + "'" + destination + "'";

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




}