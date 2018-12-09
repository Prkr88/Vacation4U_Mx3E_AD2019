package Model;

import View.Main;

import java.sql.*;

/**
 *
 * @author Mx3e
 */
public class UpdateApp extends SqlApp{

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
     * @param userName user name
     * @param password password
     * @param bDate birth date
     * @param pName person name
     * @param lName last name
     * @param city city of origin
     */
    public void updateUser(String userName ,String password,String bDate,String pName,String lName,String city) {

        String sqlRetrieve = "SELECT user_name,password,birth_date,private_name,last_name,city_of_origin FROM Users WHERE user_name = " + "'" + Main.signedUserName  + "'";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sqlRetrieve)){
            thisPass = rs.getString("password");
            thisBirth = rs.getString("birth_date");
            thisPName = rs.getString("private_name");
            thisLName = rs.getString("last_name");
            thisCity = rs.getString("city_of_origin");
        }
        catch (SQLException e) {
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

}