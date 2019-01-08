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
     * @param buyerID     of user name.
     */
    public void deleteVacationRequest(int vacationID, String buyerID) {
        String sql = "DELETE FROM VacationsRequests WHERE vacation_id = ? AND buyer_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, vacationID);
            pstmt.setString(2, buyerID);
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

    public void deleteAfterSwap(int vID_A, int vID_B) {
        String sql1 = "DELETE FROM SwapOfferedVacations WHERE vacation_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql1)) {
            // set the corresponding param
            pstmt.setInt(1, vID_A);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sql3 = "DELETE FROM VacationsRequests WHERE vacation_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql3)) {
            // set the corresponding param
            pstmt.setInt(1, vID_A);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sql4 = "DELETE FROM VacationsRequests WHERE vacation_id= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql4)) {
            // set the corresponding param
            pstmt.setInt(1, vID_B);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAfterSwapConfirmation(int vID_A, int vID_B) {
        String sql2 = "DELETE FROM SwapRequestsVacations WHERE vID_A= ? AND vID_B= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            // set the corresponding param
            pstmt.setInt(1, vID_A);
            pstmt.setInt(2, vID_B);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }



}