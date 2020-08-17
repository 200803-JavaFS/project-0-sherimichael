package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.services.TransaxnService;

import java.util.Scanner;

public class MemberScreen {
	
	private static final Logger log = LogManager.getLogger(WelcomeConsole.class); 
	private static final Scanner scan = new Scanner(System.in);
	private int id;
	private double b;
	
	public void MemberApp(int userId) {
		log.info("@MemberApp in MemberScreen");
		
		System.out.println("\nWelcome back! What would you like to do today? \n"
		          + "1. Check an account balance. \n"
		          + "2. Make a deposit.\n"
		          + "3. Make a withdrawel.\n"
		          + "4. Transfer money from one account to another."
		          + "5. Exit."
			);
			String choice = scan.nextLine(); 
			selectMenuSwitch(choice, userId);
		}
	
	public void selectMenuSwitch(String choice, int userId) {
		
		TransaxnService transaxn = new TransaxnService();

		switch(choice){
			case "1": 
				log.info("@selectMenuSwith - checking balance");
				b=transaxn.getAcntBalance(choice, userId);
				//System.out.println("Your new checking balance is $" + b);
			case "2":			
				log.info("@selectMenuSwith - deposit");
				System.out.println("What is the amount you want to deposit?");
				String s = scan.nextLine();
				int amount = Integer.parseInt(s);
				b = transaxn.DepositMoney(userId, amount);
				//System.out.println("Your new checking balance is $" + b);
				break;
			case "3": 
				log.info("@selectMenuSwith - withdraw");
				System.out.println("What is the amount you want to withdraw?");
				String s2 = scan.nextLine();
				int wAmount = Integer.parseInt(s2);
				transaxn.WithdrawMoney(userId, wAmount);
				break;
			case "4":
				log.info("@selectMenuSwith - transfer");
				transaxn.TransferMoney();
				break;
			case "5":
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
		          + "5. Exit."
			);
			id = userId;
			String choice = scan.nextLine(); 
			selectMenuSwitch(choice, userId);
		}
}
