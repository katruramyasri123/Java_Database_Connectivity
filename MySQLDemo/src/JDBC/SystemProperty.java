package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SystemProperty {
    public static void main(String[] args) {
        String url = System.getProperty("ur");
        String user = System.getProperty("un");
        String password = System.getProperty("pw");

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to database
            Connection con = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Insert a row
            stmt.executeUpdate("INSERT INTO student (RNO, UNAME) VALUES(2, 'ramya')");

            System.out.println("Data inserted successfully");

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } 
    }
}
