//This class creates an instance of the Logger object

package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.utils.IdUser;

public class Driver {
	
	//This is an example of a Singleton design pattern. Only one logger will ever exist. 
	private static final Logger log = LogManager.getLogger(Driver.class); 
	
	public static void main(String[] args){
		log.info("The application has started");
		
		IdUser start = new IdUser();
		start.idUserType();
		
		log.info("The application is ending") ;
	}
}
