package Model;

import java.sql.*;

/**
 * this generic class of sql apliction holds generic methods for all sqlApps to use.
 * every sqlApp in the program extends it.
 * @author  Mx3E
 */
public class SqlApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    public Connection connect() {
        System.out.println(System.getProperty("user.dir")+"\\src\\resources\\Vacation.db");
        String url = "jdbc:sqlite:src\\resources\\Vacation.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * get users password
     * @param userName we want to retrieve password for
     * @return user's password or null if not found
     */
    public String getUserPassword(String userName) {
        String sql = "SELECT password FROM Users WHERE user_name = " + "'" + userName + "'";
        String passFromDB = null;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            passFromDB = rs.getString("password");
            return passFromDB;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * checks id certain user is loged in to the system
     * @param userName
     * @param password
     * @return true if loged in.
     */
    public boolean loogIn(String userName, String password) {
        boolean ans = false;
        if(password.equals(getUserPassword(userName))){
            ans=true;
        }
        return ans;
    }

    /**
     * checks if user exists in the DB
     * @param userName to check
     * @return userName if found. else null.
     */
    public String checkIfUserInDB(String userName) {
        String sql = "SELECT user_name FROM Users WHERE user_name = " + "'" + userName + "'";
        String userFromDB = null;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            userFromDB = rs.getString("user_name");
            return userFromDB;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
