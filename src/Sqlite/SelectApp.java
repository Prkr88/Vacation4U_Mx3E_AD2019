package Sqlite;

import java.sql.*;

public class SelectApp extends SqlApp{



    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT user_name,password,birth_date,private_name,last_name,city_of_origin FROM Users";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("user_name") +  "\t" +
                        rs.getString("password") + "\t" +
                        rs.getString("birth_date") + "\t" +
                        rs.getString("private_name") + "\t" +
                        rs.getString("last_name") + "\t" +
                        rs.getString("city_of_origin"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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




}