package JDBC;
import java.sql.*;
import java.io.*;
public class SqlInjection {
	 public static void main(String[] args) {
	        try {
	        	InputStreamReader i=new InputStreamReader(System.in);
	        	BufferedReader r=new BufferedReader(i);
	        	System.out.println("Enter roll no:");
	        	String pass = null;
				try {
					pass = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	System.out.println("Enter usernaem");
	        	String uname = null;
				try {
					uname = r.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            // Load MySQL driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Connect to database
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/school", "root", "ramya");

	            // Create statement
	            Statement stmt = con.createStatement();

	            // Insert a row
//	            stmt.executeUpdate("INSERT INTO student VALUES("+rno+", '"+uname+"')");
	            ResultSet res=stmt.executeQuery("select balance from balance where uname='"+uname+"' and pword='"+pass+"'");
	            if(res.next()) {
	            	System.out.println(res.getDouble(1));
	            }
	            // Close connection
	            con.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("Driver not found: " + e);
	        } catch (SQLException e) {
	            System.out.println("SQL error: " + e);
	        }
	    }


}
