package com.revature.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.services.TransaxnService;



public class EmployeeScreen {
	private static final Logger log = LogManager.getLogger(EmployeeScreen.class);
	private static final Scanner scan = new Scanner(System.in);
	
	public void EmployeeApp(int userId) {
		log.info("@EmployeeApp in EmployeeScreen");
			
		System.out.println("\nWelcome valued Employee! What would you like to do today? \n"
			         + "1. Access a member's account balance. \n"
			         + "2. Access a member's account information.\n"
			         + "3. Access a member's personal information"
			         + "4. Approve/Deny an account application.\n"
			         + "5. Exit."
		);
		String choice = scan.nextLine(); 
		selectMenuSwitch(choice, userId);
	}
	
public void selectMenuSwitch(String choice, int userId) {
		
		TransaxnService transaxn = new TransaxnService();
		double b;

		switch(choice){
			case "1": 
				log.info("@selectMenuSwith - accessing member account info");
				transaxn.getAcntBalance(choice, userId);
			case "2":			
				log.info("@selectMenuSwith - accessing account member information");
				transaxn.CheckAcntInfo(userId);
				
			case "3": 
				log.info("@selectMenuSwith - accessing personal member information");
				transaxn.CheckPersonalInfo(userId);
				break;
			case "4": 
				log.info("@selectMenuSwith - approve/deny an account application");
				break;
			case "5":
				log.info("@selectMenuSwith - exit");
				System.out.println("Thank you. We hope to see you again soon.");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				EmployeeApp(userId);
				break;
			}
	}
		
}

