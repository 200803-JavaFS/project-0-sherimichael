package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class IdUser {
	
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	private static final Scanner scan = new Scanner(System.in);
	
	public void idUserType() {
		log.info("@UserType");
		System.out.println("Good day! So The Credit Union can best help you,\n"
				          + "please identify who you are:\n"
						  + "1. A Member or Soon-to-be Member\n"
				          + "2. An employee\n"
						  + "3. An Admin\n"
		);
		
		String choice = scan.nextLine(); 
		idChoiceSwitch(choice);
	}
	
	private void idChoiceSwitch(String choice) {
		
		switch(choice){
			case "1": 
				WelcomeConsole welcome = new WelcomeConsole();
				welcome.welcomeApp();
				break;
			case "2":
				System.out.println("Go to Employee Portal");
				break;
			case "3":
				System.out.println("Go to Admin Portal");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				idUserType();
				break;
		}
	}

}
