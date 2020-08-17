package com.revature.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdminScreen {
	
	private static final Logger log = LogManager.getLogger(EmployeeScreen.class);
	private static final Scanner scan = new Scanner(System.in);
	
	public void alertNewAcntRequested(int userId) {
		log.info("@alertNewAcntRequested() in AdminScreen");
		System.out.println("ATTN Admins: Member " + userId + " would like to open a new account.\n"
				+ "Please contact this member.");
	}
	
	public void createNewAcnt() {
		log.info("@createNewAcnt() in AdminScreen");
		
	}
	
	

}
