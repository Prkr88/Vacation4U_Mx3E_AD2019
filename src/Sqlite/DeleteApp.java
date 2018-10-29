package Sqlite;

import java.sql.*;

/**
 *
 * @author Mx3E
 */
public class DeleteApp extends SqlApp{

    /**
     * Delete a user specified by the userName and password
     *  will FAIL if incorrect password.
     * @param userName to delete
     * @param password of user name.
     */
    public void deleteUser(String userName, String password) {
        String sql = "DELETE FROM Users WHERE user_name = ?";
        String passFromDB;
        passFromDB = getUserPassword(userName);
        if (passFromDB != null && passFromDB.equals(password)) {
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setString(1, userName);
                // execute the delete statement
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }




}