package com.ibm.crm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtilityConnectivity {
	
	private static String URL="jdbc:mysql://localhost:3306/coredatabse";
	private static String USER="root";
	private static String PASSWORD="root";
	
	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return con;
		
	}
	
	public static void closeResurces(Connection con, PreparedStatement ps) {
		if(con !=null || ps !=null  ) {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}

}
