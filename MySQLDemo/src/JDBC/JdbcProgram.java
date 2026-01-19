package JDBC;
import java.sql.*;
import java.util.*;
import java.io.*;
public class JdbcProgram {
	 public static void main(String[] args) {
	        try {
	        	
	            // Load MySQL driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Connect to database
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/school", "root", "ramya");

	            // Create statement
	            Statement stmt = con.createStatement();

	            // Insert a row
	            stmt.executeUpdate("INSERT INTO student VALUES(1,'ramya')");
	            System.out.println("Data inserted successfully");

	            // Close connection
	            con.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("Driver not found: " + e);
	        } catch (SQLException e) {
	            System.out.println("SQL error: " + e);
	        }
	    }


}
