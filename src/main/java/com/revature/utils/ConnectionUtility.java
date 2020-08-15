package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	
	public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks will need to register our Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			log.info("@ConnectionUtility - ClassNotFoundExeption");
			e.printStackTrace();
		}
		
		String endpoint = "jdbc:postgresql://javafs200803.cicoda1qunaq.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "comAW416"; 
		
		return DriverManager.getConnection(endpoint, username, password);
	}
	
	public static void main(String[] args) {
		
		/*
		 * Try with resources block. The try statement will stake a method that creates a resource, that will
		 *automatically be closed at the end of the try or catch block. It avoids the need for a finally block.
		*/

		try(Connection conn = ConnectionUtility.getConnection()){
				System.out.println("connection successful");
				
		} catch(SQLException e) {
			log.info("@main test ConnectionUtility - SQLException");
			e.printStackTrace();
			
		}

	}
}

