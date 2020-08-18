package com.revature.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.models.User;

public class AdminScreen {
	
	private static final Logger log = LogManager.getLogger(EmployeeScreen.class);
	private static final Scanner scan = new Scanner(System.in);
	
	AccountDAO aDao = new AccountDAO();
	
	public void AdminApp() {
		log.info("@AdminApp() in AdminScreen");
		System.out.println("\n\nWelcome valued Admin!\n"
				 + "What would you like to do today? \n\n"
		         + "1. Access a member's account information.\n"
		         + "2. Access a member's user profile.\n"
		         + "3. Deposit/Withdraw/Transfer Money\n"
		         + "4. Confirm a new member.\n"
		         + "5. Confirm a new account.\n"
		         + "6. Create a new account.\n"
		         + "7. Exit\n"
	);
	String choice = scan.nextLine(); 
	//selectMenuSwitch(choice);
	}
	
	public void alertNewAcntRequested(int userId) {
		log.info("@alertNewAcntRequested() in AdminScreen");
		System.out.println("ATTN Admins: Member " + userId + " would like to open a new account.\n"
				+ "Please contact this member.");
	}
	
	public void createNewAcnt(User NewMember) {
		log.info("@createNewAcnt() in AdminScreen");
		UserDAO uDao = new UserDAO();
		NewMember.getUserId();
		
		//aDao.addAccount(		
		
	}
	
	

}
