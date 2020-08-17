package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.services.TransaxnService;

import java.util.Scanner;

public class MemberScreen {
	
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	private static final Scanner scan = new Scanner(System.in);
	private int id;
	
	public void MemberApp(int userId) {
		log.info("@MemberApp in MemberScreen");
		
		System.out.println("\nWelcome back! What would you like to do today? \n"
		          + "1. Check an account balance. \n"
		          + "2. Make a deposit.\n"
		          + "3. Make a withdrawel.\n"
		          + "4. Transfer money from one account to another."
		          + "5. Open a new account.\n"
		          + "6. Exit\n."
			);
			String choice = scan.nextLine(); 
			selectMenuSwitch(choice, userId);
	}
	
	public void selectMenuSwitch(String choice, int userId) {
		
		TransaxnService transaxn = new TransaxnService();

		switch(choice){
			case "1": 
				log.info("@selectMenuSwith - checking balance");
				transaxn.getAcntBalance(choice, userId, 1);
			case "2":			
				log.info("@selectMenuSwith - deposit");
				System.out.print("\nWhat is the amount you want to deposit? $");
				String s = scan.nextLine();
				double amount = Double.parseDouble(s);
				transaxn.depositMoney(userId, amount);
				break;
			case "3": 
				log.info("@selectMenuSwith - withdraw");
				System.out.println("What is the amount you want to withdraw? $");
				String s2 = scan.nextLine();
				double wAmount = Double.parseDouble(s2);
				transaxn.withdrawMoney(userId, wAmount);
				break;
			case "4":
				log.info("@selectMenuSwith - transfer");
				transaxn.transferMoney();
				break;
			case "5":
				System.out.println("An admin of The Credit Union will contact you soon to help\n"
						+ "you open a new account. Thank you!");
				AdminScreen aScreen = new AdminScreen();
				aScreen.alertNewAcntRequested(userId);
				break;
			case "6":
				System.out.println("Thank you. We hope to see you again soon.");
				break;
			default:
				System.out.println("You have entered an incorrect value. Please try again.");
				MemberApp(id);
				break;
			}
	}
	
	public void MoreMemberAxns(int userId) {
		log.info("@MoreMemberAxns in MemberScreen");
		
		System.out.println("\nMay we help you with anything else today? \n"
		          + "1. Check an account balance. \n"
		          + "2. Make a deposit.\n"
		          + "3. Make a withdrawel.\n"
		          + "4. Transfer money from one account to another."
		          + "5. Open a new account.\n"
		          + "6. Exit."
			);
			id = userId;
			String choice = scan.nextLine(); 
			selectMenuSwitch(choice, userId);
		}
}
