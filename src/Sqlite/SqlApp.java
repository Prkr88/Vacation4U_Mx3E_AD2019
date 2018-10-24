package Sqlite;

import java.sql.*;

public class SqlApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    public Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite://resources/Vacation.db";
        //String url = "jdbc:sqlite:resources/Vacation.db";
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

    public boolean loogIn(String userName, String password) {
        boolean ans = false;
        if(password.equals(getUserPassword(userName))){
            ans=true;
        }
        return ans;
    }
}
