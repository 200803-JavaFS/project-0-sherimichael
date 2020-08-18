package com.revature.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.TransaxnService;



public class EmployeeScreen {
	private static final Logger log = LogManager.getLogger(EmployeeScreen.class);
	private static final Scanner scan = new Scanner(System.in);
	User NewMember = new User();
	Account NewAcnt = new Account();
	
	public void EmployeeApp() {
		log.info("@EmployeeApp in EmployeeScreen");
			
		System.out.println("\n\nWelcome valued Employee!\n"
					 + "What would you like to do today? \n\n"
			         + "1. Access a member's checking account information.\n"
			         + "2. Access a member's savings account information.\n"
			         + "3. Access a member's user profile.\n"
			         + "4. Check if there are pending new member profiles.\n"
			         + "4. Confirm a new member.\n"
			         + "5. Confirm a new account.\n"
			         + "6. Exit\n"
		);
		String choice = scan.nextLine(); 
		selectEmpMenuSwitch(choice);
	}
	
	public void selectEmpMenuSwitch(String choice) {
		
		TransaxnService transaxn = new TransaxnService();
		TransaxnsScreen ts = new TransaxnsScreen();
		UserDAO uDao = new UserDAO();
		Account acnt= new Account();
		User user = new User();
		int memberUserId;

		switch(choice){
			case "1": 
				log.info("@selectMenuSwitch - accessing member checking account info");
				System.out.print("What is the member number for the checking account"
						+"you would like to access: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				acnt = transaxn.checkAcntInfo(memberUserId);
				if (acnt.getAcntType() == 1) {
					System.out.println("Checking account Info for" + acnt.getUserID() + ":" + acnt +"\n");	
				} else {System.out.println("This member does not have an active checking account.");}	
				//MoreEmpAxns();
				break;
			case "2":			
				log.info("@selectMenuSwitch - accessing savings account member information");
				System.out.print("What is the member number for the savings account"
						+"you would like to access: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				acnt = transaxn.checkAcntInfo(memberUserId);
				if (acnt.getAcntType() == 1) {
					System.out.println("Account Info for " + acnt.getAccountId() + " for " + acnt.getUserID() + ":" + acnt);	
				} else {System.out.println("This member does not have an active checking account.");}	
				MoreEmpAxns();
				break;
			case "3": 
				log.info("@selectMenuSwitch - accessing member user profile");
				System.out.print("\nEnter the member number of the user profile you would "
						+ "like to access: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				user = transaxn.checkPersonalInfo(memberUserId);
				System.out.println("\nMember profile for member number " + user.getUserId() + ":" + user + "\n");
				MoreEmpAxns();
				break;
			case "4":
				log.info("@selectMenuSwitch - checking for pending member user profiles");
			
				System.out.println("\n" + transaxn.CheckPendingUserProfiles() + "\n");
				MoreEmpAxns();
				break;
			case "5":
				log.info("@selectMenuSwitch - confirm new Member");
				confirmNewMember(NewMember);
				MoreEmpAxns();
				break;
			case "6":
				log.info("@selectMenuSwitch - confirm new Account (for new or current members)");
				confirmNewAcnt(NewAcnt);
				MoreEmpAxns();
				break;
			case "7":
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
	
	public void MoreEmpAxns() {
		log.info("@MoreMemberAxns in MemberScreen");
		
		System.out.println("\nWould you like to do anything else today? \n"
				+ "1. Access a member's checking account information.\n"
		         + "2. Access a member's savings account information.\n"
		         + "3. Access a member's user profile.\n"
		         + "4. Check if there are pending new member profiles.\n"
		         + "4. Confirm a new member.\n"
		         + "5. Confirm a new account.\n"
		         + "6. Exit\n"
		         
			);
			String choice = scan.nextLine(); 
			selectEmpMenuSwitch(choice);
		}
	//************************ New Member Services ****************************************
	
	public void confirmNewMember(User NewMember) {
		log.info("@ in EmployeeScreen");
		//transaxn.confirmNewMember(NewMember);	
	}
	
	public void confirmNewAcnt(Account NewAcnt) {
		log.info("@ in EmployeeScreen");
		//transaxn.confirmNewAcnt(NewAcnt);	
	}
}


