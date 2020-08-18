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
	
	public void EmployeeApp() {
		log.info("@EmployeeApp in EmployeeScreen");
			
		System.out.println("\n\nWelcome valued Employee!\n"
					 + "What would you like to do today? \n\n"
			         + "1. Access a member's checking account information.\n"
			         + "2. Access a member's savings account information.\n"
			         + "3. Access a member's user profile.\n"
			         + "4. Check if there are pending new member profiles.\n"
			         + "5. Confirm a new member.\n"
			         + "6. Confirm a new checking account.\n"
			         + "7. Confirm a new savings account.\n"
			         + "8. Exit\n"
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
						+" you would like to access: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				acnt = transaxn.checkAcntInfo(memberUserId);
				user = uDao.findById(memberUserId);
				if (user.getUserType() == 4) {
					System.out.println("/nYour account(s) is/are not yet active. Please see an admin./n");
				}
				else if (acnt.getAcntType() == 1) {
					System.out.println("/nChecking account info for member " + acnt.getUserID() +":" + acnt +  "/n");
					System.out.print(acnt);
				} else if (acnt.getAcntStatus() == 0) {
					System.out.println("/nThis checking account for member " + acnt.getUserID() + " is closed./n");	
				}else{
					System.out.println("/nThis current member does not have an active checking account./n");
				}	
				MoreEmpAxns();
				break;
			case "2":			
				log.info("@selectMenuSwitch - accessing savings account member information");
				System.out.print("What is the member number for the savings account"
						+" you would like to access: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				acnt = transaxn.checkAcntInfo(memberUserId);
				if (acnt.getAcntType() == 2) {
					System.out.println("\nSavings account info for member " + acnt.getAccountId() + " for " + acnt.getUserID() + ":" + acnt);	
				} else if (acnt.getAcntStatus() == 0) {
					System.out.println("/nThis savings account for member " + acnt.getUserID() + " is closed./n");	
				}else {System.out.println("This member does not have an active savings account.");}	
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
				System.out.print("What is the member number for the profile"
						+" you would like to confirm: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				transaxn.confirmNewMember(memberUserId);	
				MoreEmpAxns();
				break;
			case "6":
				log.info("@selectMenuSwitch - confirm new checking account (for new or current members)");
				System.out.print("What is the member number whose new checking account you would like to confirm: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				transaxn.confirmNewCheckingAcnt(memberUserId);	
				MoreEmpAxns();confirmNewAcnt(acnt);
				MoreEmpAxns();
				break;
			case "7":
				log.info("@selectMenuSwitch - confirm new savings account (for new or current members)");
				System.out.print("What is the member number whose new savings account you would like to confirm: ");
				memberUserId = Integer.parseInt(scan.nextLine());
				transaxn.confirmNewSavingsAcnt(memberUserId);	
				MoreEmpAxns();confirmNewAcnt(acnt);
				MoreEmpAxns();
			case "8":
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
		         + "5. Confirm a new member.\n"
		         + "6. Confirm a new checking account.\n"
		         + "7. Confirm a new savings account.\n"
		         + "8. Exit\n"
		         
			);
			String choice = scan.nextLine(); 
			selectEmpMenuSwitch(choice);
		}
	//************************ New Member Services ****************************************
	
	public void confirmNewMember(int memberUserId) {
		log.info("@confirmNewMember in EmployeeScreen");
		//transaxn.confirmNewMember(NewMember);	
	}
	
	public void confirmNewAcnt(Account NewAcnt) {
		log.info("@ in EmployeeScreen");
		//transaxn.confirmNewAcnt(NewAcnt);	
	}
}


