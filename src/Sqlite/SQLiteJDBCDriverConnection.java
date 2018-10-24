package Sqlite;

import java.sql.*;

/**
 * @author sqlitetutorial.net
 */
public class SQLiteJDBCDriverConnection {
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:resources/Vacation.db";
            //String url = "jdbc:sqlite:C:/Users/edoli/IdeaProjects/Vacation4U_Mx3E_AD2019/resources/Vacation.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }



    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:resources/Vacation.db" + fileName;
        //String url = "jdbc:sqlite:C:/Users/edoli/IdeaProjects/Vacation4U_Mx3E_AD2019/resources/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:resources/Vacation.db";
        //String url = "jdbc:sqlite:C:/Users/edoli/IdeaProjects/Vacation4U_Mx3E_AD2019/resources/Vacation.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "	user_name text PRIMARY KEY,\n"
                + "	password text NOT NULL,\n"
                + "	birth_date date NOT NULL,\n"
                + "	private_name text NOT NULL,\n"
                + "	last_name text NOT NULL,\n"
                + "	city_of_origin text NOT NULL\n"
                + ");";


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //connect();
       // createNewDatabase("Vacation.db");
        //createNewTable();
        SqlApp sqlApp = new SqlApp();
        InsertApp iApp = new InsertApp();
       // iApp.insert("edoLior","123456","1990-10-01","Edo","Lior","Herzeliya");
        SelectApp sApp = new SelectApp();
        sApp.selectAll();
        DeleteApp dApp = new DeleteApp();
        //dApp.deleteUser("edoLior","123456");
       UpdateApp uApp = new UpdateApp();
        uApp.updateUser("edoLior","123456","1990-10-2","Edo","Lior","Beer-Sheva");
       // sApp.selectAll();
        System.out.println(sqlApp.loogIn("edoLior","123456"));
    }
}