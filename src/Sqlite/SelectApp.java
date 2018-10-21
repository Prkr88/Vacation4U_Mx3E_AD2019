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




}