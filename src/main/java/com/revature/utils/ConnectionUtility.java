package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	
	/*
	 * public static Connection getConnection() throws SQLException {
	 
		
		String url = "jdbc:postgresql://javafs200803.cicoda1qunaq.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "comAW416";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	*/
	
	public static Connection conn = null;
	public static Connection getConnection() throws SQLException {
		try {
			if (conn == null) {
				//step1 load the driver class 
				System.out.println("null");
				Class.forName("org.pstgreql.Driver");
				
				//step2 create the connection object
				String endpoint = "jdbc:postgresql://javafs200803.cicoda1qunaq.us-east-2.rds.amazonaws.com:5432/postgres";
				String username = "postgres";
				String password = "comAW416";
				
				conn = DriverManager.getConnection(endpoint, username, password);
				System.out.println("null" + conn);
				return conn;
				
			} else {
				System.out.println(conn);
				return conn;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	//This main method is only for testing purposes
		//It won't be where our actual application runs from.
		public static void main(String[] args) throws SQLException {
			Connection conn1 = getConnection();
			Connection conn2 = getConnection();
			Connection conn3 = getConnection();
			
			System.out.println(conn1);
			System.out.println(conn2);
			System.out.println(conn3);
		}
	

}
