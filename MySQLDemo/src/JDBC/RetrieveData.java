package JDBC;
import java.sql.*;
import java.io.*;
public class RetrieveData {
public static void main(String arg[]) {
	String driver1="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/school";
	String username="root";
	String pwd="ramya";
	try {
		Class.forName(driver1);
		Connection con=DriverManager.getConnection(url,username,pwd);
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery("select * from student");
		while(res.next()) {
			System.out.println(res.getInt(1)+"\t"+res.getString(2));
		}
		con.close();
	}
	catch(Exception e) {
		System.out.print(e);
	}
	
}
}
