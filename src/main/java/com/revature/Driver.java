//This class creates an instance of the Logger object

package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.utils.WelcomeConsole;

import com.revature.models.Account;
import com.revature.services.AccountServices;

public class Driver {
	
	//This is an example of a Singleton design pattern. Only one logger will ever exist. 
	private static final Logger log = LogManager.getLogger(Driver.class); 
	
	public void start() {
		WelcomeConsole start = new WelcomeConsole();
		start.beginApp();
	}
	/*
	private static AccountServices acntSrvs = new AccountServices();

	public static void main(String[] args) {
		log.info("The application has started");
		
		
//		try {
//			recur();
//		} catch (Error e) {
//			log.error("Oh no! We encountered an error!");
//		}
		
		Account acnt = acntSrvs.findAccountById(1);
		
		log.info("We have found account: "+acnt);
		
		
		log.info("The application is ending") ;
		
		
	}
	
	public static void recur() {
		recur(); 
	}
	*/

}
