package Model;

import View.Main;

import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<ArrayList<String>> displayVacations() {
        String sql = "SELECT * FROM OfferedVacations";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = getArrayFromTable(sql);
        return data;
    }

    public ArrayList<ArrayList<String>> getArrayFromTable(String sql)
    {
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

    public ArrayList<ArrayList<String>> displaySwapVacations() {
        String sql = "SELECT * FROM SwapOfferedVacations";

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
