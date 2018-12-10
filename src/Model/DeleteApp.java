package Model;

import java.sql.*;

/**
 *
 * @author Mx3E
 */
public class DeleteApp extends SqlApp {

    /**
     * Delete a user specified by the userName and password
     * will FAIL if incorrect password.
     *
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
                deleteDeletedUserVacations(userName);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Deletes Vacation Request if a Buyer regrets
     *
     * @param vacationID to delete
     * @param userID     of user name.
     */
    public void deleteVacationRequest(int vacationID, String userID) {
        String sql = "DELETE FROM VacationsRequests WHERE vacation_id = ? AND user_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, vacationID);
            pstmt.setString(2, userID);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a user specified by the userName and password
     * will FAIL if incorrect password.
     * @param userID     of user name.
     */
    public void deleteDeletedUserVacations(String userID) {
        String sql = "DELETE FROM OfferedVacations WHERE seller_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setString(1, userID);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a user specified by the userName and password
     * will FAIL if incorrect password.
     * @param vacationID     of user name.
     */
    public void deleteOfferedVacations(int vacationID) {
        String sql = "DELETE FROM OfferedVacations WHERE vacation_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, vacationID);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        DeleteApp delA = new DeleteApp();
        //delA.deleteVacationRequest(1,"GregSM");
        delA.deleteDeletedUserVacations("Edo");
    }



}