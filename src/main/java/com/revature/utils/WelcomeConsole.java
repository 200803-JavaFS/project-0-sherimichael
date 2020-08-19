package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class WelcomeConsole {
	
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	private static final Scanner scan = new Scanner(System.in);
	
	public void welcomeApp() {
		log.info("@welcomeApp - Welcome to The Credit Union");
		System.out.println("Welcome to The Credit Union. \n\n"
			
				+ "How may we help you today? Please select below: \n\n"
				+ "1. Take me to the login page. \n"
				+ "2. Take me to the new member page. \n"
				+ "3. Exit"
		);
		String choice = scan.nextLine();
		welcomeChoiceSwitch(choice);
	}
	
	private void welcomeChoiceSwitch(String choice) {
		
		switch(choice){
			case "1": 
				LoginScreen login= new LoginScreen();
				login.acntLogin();
				break;
			case "2":
				NewMemberScreen newMember= new NewMemberScreen();
				newMember.checkAgeNewMember();
				break;
			case "3":
				System.out.println("Thank you. We hope to see you again soon.");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				welcomeApp();
				break;
		}
	}

}
