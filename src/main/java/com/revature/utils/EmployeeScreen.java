package com.revature.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.TransaxnService;



public class EmployeeScreen {
	private static final Logger log = LogManager.getLogger(EmployeeScreen.class);
	private static final Scanner scan = new Scanner(System.in);
	User NewMember = new User();
	Account NewAcnt = new Account();
	
	TransaxnService transaxn = new TransaxnService();
	
	public void EmployeeApp() {
		log.info("@EmployeeApp in EmployeeScreen");
			
		System.out.println("\n\nWelcome valued Employee!\n"
					 + "What would you like to do today? \n\n"
			         + "1. Access a member's account balance. \n"
			         + "2. Access a member's account information.\n"
			         + "3. Access a member's personal information.\n"
			         + "4. Confirm a new member.\n"
			         + "5. Confirm a new account.\n"
			         + "6. Exit.\n"
		);
		String choice = scan.nextLine(); 
		selectMenuSwitch(choice);
	}
	
	public void selectMenuSwitch(String choice) {

		switch(choice){
			case "1": 
				log.info("@selectMenuSwitch - accessing member account info");
				System.out.print("Enter the member number of the account you would like the balance for: ");
				int memberUserId = Integer.parseInt(scan.nextLine());
				transaxn.getAcntBalance(choice, memberUserId, 2);
			case "2":			
				log.info("@selectMenuSwitch - accessing account member information");
				System.out.print("Enter the member number of the account you would like information for: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				transaxn.checkAcntInfo(memberUserId);			
			case "3": 
				log.info("@selectMenuSwitch - accessing personal member information");
				System.out.print("Enter the member number of the account you would like the balance for: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				transaxn.checkPersonalInfo(memberUserId);
				break;
			case "4":
				log.info("@selectMenuSwitch - confirm new Member");
				confirmNewMember(NewMember);
				break;
			case "5":
				log.info("@selectMenuSwitch - confirm new Account (for new or current members)");
				confirmNewAcnt(NewAcnt);
				break;
			case "6":
				log.info("@selectMenuSwitch - exit");
				System.out.println("Thank you. We hope to see you again soon.");
				break;
			default:
				log.info("@selectMenuSwitch - invalid response");
				System.out.println("You have entered an incorrect value. Please select again.");
				EmployeeApp();
				break;
			}
		}
	//************************ New Member Services ****************************************
	
	public void confirmNewMember(User NewMember) {
		log.info("@ in EmployeeScreen");
		transaxn.confirmNewMember(NewMember);	
	}
	
	public void confirmNewAcnt(Account NewAcnt) {
		log.info("@ in EmployeeScreen");
		transaxn.confirmNewAcnt(NewAcnt);	
	}
}


