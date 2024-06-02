package com.ibm.crm.util.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ibm.crm.util.DatabaseUtilityConnectivity;
import com.ibm.crm.util.SQLQueryies.SQLQuerys;

public class BusinessProcess {

	String sqlCreateTable = "create table customer(custid int,custname varchar(30))";

	Connection con = null;
	PreparedStatement ps = null;

	public void creatTable() {

		try {
			con = DatabaseUtilityConnectivity.getDatabaseConnection();
			ps = con.prepareStatement(SQLQuerys.sqlCreateTable);
			int executeUpdateresult = ps.executeUpdate();
			System.out.println("Table created successfully :>>> " + executeUpdateresult);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtilityConnectivity.closeResurces(con, ps);

		}

	}
	
	public void insertIntoTable() {
		try {
			con = DatabaseUtilityConnectivity.getDatabaseConnection();
			ps = con.prepareStatement(SQLQuerys.sqlInserQuery);
			ps.setInt(1, 4444);
			ps.setString(2, "Jalaj");
			int executeUpdateResult = ps.executeUpdate();
			System.out.println("Record inserted successfully :>>> " + executeUpdateResult);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtilityConnectivity.closeResurces(con, ps);
		}
	}

}
