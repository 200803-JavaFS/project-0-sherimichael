package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import com.revature.Driver;
import com.revature.services.UserServices;

public class LoginScreen {
	
	private static final Logger log = LogManager.getLogger(LoginScreen.class); 
	private static final Scanner scan = new Scanner(System.in);
	
	public void acntLogin() {
		
		log.info("@acntLogin");
		
		
		
		System.out.println("\nWelcome back! What would you like to do today? \n"
				          + "1. Check an account balance. \n"
				          + "2. Make a deposit.\n"
				          + "3. Make a withdrawel.\n"
				          + "4. Transfer money from one account to another."
				          + "5. Exit."
	    );
		String choice = scan.nextLine(); 
		selectMenuSwitch(choice);
	}
	
	public void selectMenuSwitch(String choice) {
		
		switch(choice){
		case "1": 
			log.info("@selectMenuSwith - checking balance");
			
			break;
		case "2":
			log.info("@selectMenuSwith - deposit");
			break;
		case "3": 
			log.info("@selectMenuSwith - withdraw");
			break;
		case "4":
			log.info("@selectMenuSwith - transfer");
			break;
		case "5":
			System.out.println("Thank you. We hope to see you again soon.");
			break;
		default:
			System.out.println("You have entered an incorrect value. Please try again.");
			acntLogin();
			break;
	}
	}
	

}
