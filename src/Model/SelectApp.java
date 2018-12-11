package Model;

import java.sql.*;
import java.util.*;


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

        try(Connection conn = this.connect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
                ResultSetMetaData md = resultSet.getMetaData();
                int columns = md.getColumnCount();
                ArrayList<ArrayList<String>> rowsList = new ArrayList<ArrayList<String>>();
                while (resultSet.next()) {
                    ArrayList<String> row = new ArrayList<String>();
                    for (int i = 1; i <= columns; ++i) {
                        row.add(resultSet.getString(i));
                    }
                    rowsList.add(row);
                }
                return rowsList;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<ArrayList<String>> selectVacationRequest(String vacationID) {
        String sql = "SELECT user_id FROM VacationsRequests WHERE vacation_id=" + "'" + vacationID + "'";

        try(Connection conn = this.connect();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            ArrayList<ArrayList<String>> rowsList = new ArrayList<ArrayList<String>>();
            while (resultSet.next()) {
                ArrayList<String> row = new ArrayList<String>();
                for (int i = 1; i <= columns; ++i) {
                    row.add(resultSet.getString(i));
                }
                rowsList.add(row);
            }
            return rowsList;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}