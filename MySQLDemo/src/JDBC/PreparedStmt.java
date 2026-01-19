package JDBC;
import java.sql.*;
import java.io.*;
public class PreparedStmt {
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
	            String qry="select balance from balance where uname=? and pword=?";

	            // Create statement
	            PreparedStatement stmt = con.prepareStatement(qry);
	            stmt.setString(1, uname);
	            stmt.setString(2, pass);
	            ResultSet res=stmt.executeQuery();
	            if(res.next()) {
	            	System.out.println(res.getDouble(1));
	            }
	            else {
	            	System.out.println("Empty");
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
