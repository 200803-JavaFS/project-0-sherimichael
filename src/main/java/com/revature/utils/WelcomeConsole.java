package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.services.UserServices;

public class WelcomeConsole {
	
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	private static final Scanner scan = new Scanner(System.in);
	/*
	 * private UserServices userSrvc = new UserServices();
	   private AccountDAO acntDao = new AccountDAO(); 
	*/
	
	public void welcomeApp() {
		log.info("@welcomeApp - Welcome to the Centennial State Credit Union");
		System.out.println("Welcome to the Centennial State Credit Union. \n\n"
			
				+ "How may we help you today? Please select below: \n\n"
				+ "1. I am a current member and would like to log into my account(s). \n"
				+ "2. I am not a member and would like to open my first account. \n"
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
				newMember.createNewMember();
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
