import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class database {

    static String[] strUser = new String[1000];
    static String[] strPass = new String[1000];
    static String[] strAccess = new String[1000];

    static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    static String user = "root";
    static String password = "Kiencon96";

    static String returnVal(String table, String where, String key, String value){
        String result;
        Connection myConn;
        try {
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            String sql = "select * from our_company." + table + " where " + where + " = " + key; // query statement
            ResultSet rs = myStmt.executeQuery(sql); //executes query
            rs.next();

            result = rs.getString(value);
        } catch (SQLException ex) {
            System.out.println("An error occurred while returning value");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static void main(String[] args){

        Connection myConn;

        try {
                myConn = DriverManager.getConnection(url,user,password);
                if (myConn != null) {
                    System.out.println("Successfully connected to MySQL database!");
                }
            } catch (SQLException ex) {
                System.out.println("An error occurred while connecting MySQL database!");
                ex.printStackTrace();
                throw new RuntimeException(ex);
        } // test mysql connection

        int counter = 0;

        try {
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            String sql = "select * from our_company.users"; // query statement
            ResultSet rs = myStmt.executeQuery(sql); //executes query

            while (rs.next()) {
                strUser[counter] = rs.getString("user_ID");
                strPass[counter] = rs.getString("password");
                strAccess[counter] = rs.getString("access");
                counter++;
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred while populating users");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } // populate usernames in strUser and passwords in strPass

        LoginPage logGUI = new LoginPage();

    }

}