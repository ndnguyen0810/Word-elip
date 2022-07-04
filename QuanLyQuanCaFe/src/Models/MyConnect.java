package Models;

import java.sql.*;

public class MyConnect {
	public static Connection getConnection() {
		Connection con = null;
		//String url = "jdbc:mysql://localhost/db_quanlycoffe?characterEncoding=UTF-8";
		String url = "jdbc:mysql://26.95.210.239/db_quanlycoffe?characterEncoding=UTF-8";
		String user = "admin";
		String pw = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("Connect successfully");
		} catch (Exception ex) {
			System.out.println("Connect Failure");
			ex.printStackTrace();
		}

		return con;
		
	}
	
	public static Connection con= MyConnect.getConnection();
}