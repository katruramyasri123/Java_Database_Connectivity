package JDBC;
import java.sql.*;
import java.io.*;
public class CallableStmt {
	public static void main(String args[]) {
		InputStreamReader i=new InputStreamReader(System.in);
		BufferedReader b=new BufferedReader(i);
		System.out.println("enter rollno:");
		int rno = 0;
		try {
			rno=Integer.parseInt(b.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","ramya");
			CallableStatement stmt=con.prepareCall("{call getName(?)}");
			stmt.setInt(1, rno);
			ResultSet res=stmt.executeQuery();
			while(res.next()) {
				System.out.println(res.getString(1));
			}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
